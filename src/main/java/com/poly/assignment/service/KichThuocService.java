package com.poly.assignment.service;

import com.poly.assignment.entity.KichThuoc;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KichThuocService {

    List<KichThuoc> listKichThuoc = new ArrayList<>();

    public KichThuocService() {
    }

    public List<KichThuoc> findAll() {
        return listKichThuoc;
    }

    public KichThuoc findById(Integer id) {
        for (KichThuoc kichThuoc: listKichThuoc) {
            if (kichThuoc.getId() == id) {
                return kichThuoc;
            }
        }

        return null;
    }

    public List<KichThuoc> findByKey(String key) {
        List<KichThuoc> result = new ArrayList<>();
        for (KichThuoc kichThuoc: listKichThuoc) {
            if (kichThuoc.getMaKT().toLowerCase().contains(key.toLowerCase()) || kichThuoc.getTen().toLowerCase().contains(key.toLowerCase())) {
                result.add(kichThuoc);
            }
        }

        return result;
    }

    public void create(KichThuoc kichThuoc) {
        listKichThuoc.add(kichThuoc);
    }

    public void update(KichThuoc kichThuoc) {
        for (int i = 0; i < listKichThuoc.size(); i++) {
            if (listKichThuoc.get(i).getId().equals(kichThuoc.getId())) {
                listKichThuoc.set(i, kichThuoc);
            }
        }
    }

    public void delete(String id) {
        List<KichThuoc> deList = new ArrayList<>();
        for (int i = 0; i < listKichThuoc.size(); i++) {
            if (listKichThuoc.get(i).getId().equals(id)) {
                deList.add(listKichThuoc.get(i));
            }
        }

        listKichThuoc.removeAll(deList);
    }

}
