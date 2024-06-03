package com.poly.assignment.service;

import com.poly.assignment.entity.KichThuoc;
import com.poly.assignment.repository.KichThuocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<KichThuoc> result = new ArrayList<>();
        for (KichThuoc kichThuoc: findAll()) {
            if (kichThuoc.getMaKT().toLowerCase().contains(key.toLowerCase()) || kichThuoc.getTen().toLowerCase().contains(key.toLowerCase())) {
                result.add(kichThuoc);
            }
        }

        return result;
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
