package com.poly.assignment.service;

import com.poly.assignment.entity.Auth;
import com.poly.assignment.entity.HoaDon;
import com.poly.assignment.entity.HoaDonChiTiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class HoaDonService {

    List<HoaDon> listHoaDon = new ArrayList<>();

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private GioHangService gioHangService;

    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;

    public HoaDonService() {
    }

    public List<HoaDon> findAll() {
        return listHoaDon;
    }

    public HoaDon findById(Integer id) {
        for (HoaDon hoaDon: listHoaDon) {
            if (hoaDon.getId() == id) {
                return hoaDon;
            }
        }

        return null;
    }

    public List<HoaDon> findByKey(String key) {
        List<HoaDon> result = new ArrayList<>();
        for (HoaDon hoaDon: listHoaDon) {
            if (hoaDon.getNhanVien().getMaNV().toLowerCase().contains(key.toLowerCase()) ||
                    hoaDon.getNhanVien().getTen().toLowerCase().contains(key.toLowerCase()) ||
                    hoaDon.getKhachHang().getMaKH().toLowerCase().contains(key.toLowerCase()) ||
                    hoaDon.getKhachHang().getTen().toLowerCase().contains(key.toLowerCase())) {
                result.add(hoaDon);
            }
        }

        return result;
    }

    public void create(HoaDon hoaDon) {
        hoaDon.setNhanVien(Auth.getLoggedInNhanVien());
        hoaDon.setKhachHang(khachHangService.findById(hoaDon.getKhachHang().getId()));
        hoaDon.setNgayMuaHang(LocalDateTime.now());
        hoaDon.setTrangThai(true);

        gioHangService.findAll().forEach(gioHang -> {
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setHoaDon(hoaDon);
            hoaDonChiTiet.setSanPhamChiTiet(gioHang.getSanPhamChiTiet());
            hoaDonChiTiet.setSoLuong(gioHang.getQuantity());
            hoaDonChiTiet.setDonGia(gioHang.getSanPhamChiTiet().getDonGia());
            hoaDonChiTiet.setTrangThai(true);
            hoaDonChiTietService.create(hoaDonChiTiet);
        });
        gioHangService.deleteAll();
        listHoaDon.add(hoaDon);
    }

    public void update(HoaDon hoaDon) {
        for (int i = 0; i < listHoaDon.size(); i++) {
            if (listHoaDon.get(i).getId().equals(hoaDon.getId())) {
                hoaDon.setNhanVien(Auth.getLoggedInNhanVien());
                hoaDon.setKhachHang(khachHangService.findById(hoaDon.getKhachHang().getId()));
                hoaDon.setNgayMuaHang(LocalDateTime.now());
                hoaDon.setTrangThai(true);
                hoaDonChiTietService.findAllHoaDonChiTietByHoaDon(hoaDon.getId()).forEach(hoaDonChiTiet -> hoaDonChiTiet.setTrangThai(true));
                listHoaDon.set(i, hoaDon);
            }
        }
    }

    public void cancel(Integer id) {
        findById(id).setTrangThai(false);
        hoaDonChiTietService.findAllHoaDonChiTietByHoaDon(id).forEach(hoaDonChiTiet -> hoaDonChiTiet.setTrangThai(false));
    }

}
