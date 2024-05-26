package com.poly.assignment.service;

import com.poly.assignment.entity.*;
import com.poly.assignment.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HoaDonService {

    List<HoaDon> listHoaDon = new ArrayList<>();

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    GioHangService gioHangService;

    @Autowired
    HoaDonChiTietService hoaDonChiTietService;

    public HoaDonService() {
        listHoaDon.add(new HoaDon("1", new NhanVien("4", "NV04", "Nguyen Thi D", "d12345", "123456", false, true), new KhachHang("1", "KH01", "Luu Thi Hai Yen", "0345674567", true), LocalDateTime.now(), true));
        listHoaDon.add(new HoaDon("2", new NhanVien("2", "NV02", "Nguyen Thi B", "b12345", "123456", false, true), new KhachHang("3", "KH03", "Do Thi Hong Khanh", "0987654321", true), LocalDateTime.now(), true));
        listHoaDon.add(new HoaDon("3", new NhanVien("3", "NV03", "Nguyen Van C", "c12345", "123456", false, true), new KhachHang("2", "KH02", "Hoang Quang Linh", "0312341234", true), LocalDateTime.now(), true));
        listHoaDon.add(new HoaDon("4", new NhanVien("1", "NV01", "Nguyen Van A", "a12345", "123456", false, true), new KhachHang("5", "KH05", "Luu Thi Hai Yen", "0956781234", true), LocalDateTime.now(), true));
        listHoaDon.add(new HoaDon("5", new NhanVien("5", "NV05", "Nguyen Van E", "e12345", "123456", false, true), new KhachHang("4", "KH04", "Luu Thi Hai Yen", "0323452345", true), LocalDateTime.now(), true));
        listHoaDon.add(new HoaDon("6", new NhanVien("5", "NV05", "Nguyen Van E", "e12345", "123456", false, true), new KhachHang("4", "KH04", "Luu Thi Hai Yen", "0323452345", true), LocalDateTime.now(), false));
    }

    public List<HoaDon> findAll() {
        return listHoaDon;
    }

    public HoaDon findById(String id) {
        for (HoaDon hoaDon: listHoaDon) {
            if (hoaDon.getId().equals(id)) {
                return hoaDon;
            }
        }

        return null;
    }

    public List<HoaDon> findByKey(String key) {
        List<HoaDon> result = new ArrayList<>();
        for (HoaDon hoaDon: listHoaDon) {
            if (hoaDon.getNhanVien().getMaNV().contains(key) ||
                    hoaDon.getNhanVien().getTen().contains(key) ||
                    hoaDon.getKhachHang().getMaKH().contains(key) ||
                    hoaDon.getKhachHang().getTen().contains(key)) {
                result.add(hoaDon);
            }
        }

        return result;
    }

    public void create(HoaDon hoaDon) {
        hoaDon.setId(UUID.randomUUID().toString());
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
                listHoaDon.set(i, hoaDon);
            }
        }
    }

    public void cancel(String id) {
        listHoaDon.forEach(hoaDon -> hoaDon.setTrangThai(false));
        hoaDonChiTietService.findAllHoaDonChiTietByHoaDon(id).forEach(hoaDonChiTiet -> hoaDonChiTiet.setTrangThai(false));
    }

}
