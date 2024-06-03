package com.poly.assignment.service;

import com.poly.assignment.entity.HoaDonChiTiet;
import com.poly.assignment.repository.HoaDonChiTietRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HoaDonChiTietService {

    private final HoaDonChiTietRepository hoaDonChiTietRepository;

    public List<HoaDonChiTiet> findAll() {
        return hoaDonChiTietRepository.findAll();
    }

    public HoaDonChiTiet findById(Integer id) {
        return hoaDonChiTietRepository.findById(id).get();
    }

    public List<HoaDonChiTiet> findByKey(String key) {
        List<HoaDonChiTiet> result = new ArrayList<>();
        for (HoaDonChiTiet hoaDonChiTiet: findAll()) {
            if (hoaDonChiTiet.getHoaDon().getId().toString().contains(key.toLowerCase()) || hoaDonChiTiet.getId().toString().contains(key.toLowerCase())) {
                result.add(hoaDonChiTiet);
            }
        }

        return result;
    }

    public List<HoaDonChiTiet> findAllHoaDonChiTietByHoaDon(Integer id) {
        List<HoaDonChiTiet> result = new ArrayList<>();
        for (HoaDonChiTiet hoaDonChiTiet: findAll()) {
            if (hoaDonChiTiet.getHoaDon().getId() == id) {
                result.add(hoaDonChiTiet);
            }
        }

        return result;
    }

    public void create(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    public void update(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    public void cancel(Integer id) {
        findById(id).setTrangThai(false);
    }

}
