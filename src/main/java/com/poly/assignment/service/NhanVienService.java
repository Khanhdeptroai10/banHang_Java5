package com.poly.assignment.service;

import com.poly.assignment.entity.NhanVien;
import com.poly.assignment.repository.NhanVienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NhanVienService {

    private final NhanVienRepository nhanVienRepository;

    public List<NhanVien> findAll() {
        return nhanVienRepository.findAll();
    }

    public NhanVien findById(Integer id) {
        return nhanVienRepository.findById(id).get();
    }

    public List<NhanVien> findByKey(String key) {
        return nhanVienRepository.findByKey(key);
    }

    public void create(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    public void update(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    public void delete(Integer id) {
        nhanVienRepository.deleteById(id);
    }

}
