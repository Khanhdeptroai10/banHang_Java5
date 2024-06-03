package com.poly.assignment.service;

import com.poly.assignment.entity.HoaDonChiTiet;
import com.poly.assignment.repository.HoaDonChiTietRepository;
import com.poly.assignment.repository.HoaDonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HoaDonChiTietService {

    private final HoaDonChiTietRepository hoaDonChiTietRepository;

    private final HoaDonRepository hoaDonRepository;

    public List<HoaDonChiTiet> findAll() {
        return hoaDonChiTietRepository.findAll();
    }

    public HoaDonChiTiet findById(Integer id) {
        return hoaDonChiTietRepository.findById(id).get();
    }

    public List<HoaDonChiTiet> findByKey(Integer key) {
        return hoaDonChiTietRepository.findByKey(key);
    }

    public List<HoaDonChiTiet> findAllHoaDonChiTietByHoaDon(Integer id) {
        return hoaDonChiTietRepository.findHoaDonChiTietByHoaDon(hoaDonRepository.findById(id).get());
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
