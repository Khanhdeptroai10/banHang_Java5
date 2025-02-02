package com.poly.assignment.service;

import com.poly.assignment.entity.KichThuoc;
import com.poly.assignment.repository.KichThuocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KichThuocService {

    private final KichThuocRepository kichThuocRepository;

    public List<KichThuoc> findAll() {
        return kichThuocRepository.findAll();
    }

    public KichThuoc findById(Integer id) {
        return kichThuocRepository.findById(id).get();
    }

    public List<KichThuoc> findByKey(String key) {
        return kichThuocRepository.findByKey(key);
    }

    public void create(KichThuoc kichThuoc) {
        kichThuocRepository.save(kichThuoc);
    }

    public void update(KichThuoc kichThuoc) {
        kichThuocRepository.save(kichThuoc);
    }

    public void delete(Integer id) {
        kichThuocRepository.deleteById(id);
    }

}
