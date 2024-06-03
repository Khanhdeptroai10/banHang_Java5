package com.poly.assignment.service;

import com.poly.assignment.entity.KhachHang;
import com.poly.assignment.repository.KhachHangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KhachHangService {

    private final KhachHangRepository khachHangRepository;

    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }

    public KhachHang findById(Integer id) {
        return khachHangRepository.findById(id).get();
    }

    public List<KhachHang> findByKey(String key) {
        return khachHangRepository.findByKey(key);
    }

    public void create(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    public void update(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    public void delete(Integer id) {
        khachHangRepository.deleteById(id);
    }

}
