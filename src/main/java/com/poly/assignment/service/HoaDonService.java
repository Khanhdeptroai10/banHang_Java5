package com.poly.assignment.service;

import com.poly.assignment.entity.Auth;
import com.poly.assignment.entity.HoaDon;
import com.poly.assignment.entity.HoaDonChiTiet;
import com.poly.assignment.repository.HoaDonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HoaDonService {

    private final HoaDonRepository hoaDonRepository;

    private final HoaDonChiTietService hoaDonChiTietService;

    private final KhachHangService khachHangService;

    private final GioHangService gioHangService;

    public List<HoaDon> findAll() {
        return hoaDonRepository.findAll();
    }

    public HoaDon findById(Integer id) {
        return hoaDonRepository.findById(id).get();
    }

    public List<HoaDon> findByKey(String key) {
        List<HoaDon> result = new ArrayList<>();
        for (HoaDon hoaDon: findAll()) {
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
        hoaDonRepository.save(hoaDon);

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
    }

    public void update(HoaDon hoaDon) {
        hoaDon.setNhanVien(Auth.getLoggedInNhanVien());
        hoaDon.setKhachHang(khachHangService.findById(hoaDon.getKhachHang().getId()));
        hoaDon.setNgayMuaHang(LocalDateTime.now());
        hoaDon.setTrangThai(true);
        hoaDonChiTietService.findAllHoaDonChiTietByHoaDon(hoaDon.getId()).forEach(hoaDonChiTiet -> hoaDonChiTiet.setTrangThai(true));
        hoaDonRepository.save(hoaDon);
    }

    public void cancel(Integer id) {
        HoaDon hoaDon = findById(id);
        hoaDon.setTrangThai(false);
        hoaDonRepository.save(hoaDon);
        hoaDonChiTietService.findAllHoaDonChiTietByHoaDon(id).forEach(hoaDonChiTiet -> {
            hoaDonChiTiet.setTrangThai(false);
            hoaDonChiTietService.update(hoaDonChiTiet);
        });
    }

}
