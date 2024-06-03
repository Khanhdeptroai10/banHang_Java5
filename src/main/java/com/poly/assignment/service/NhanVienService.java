package com.poly.assignment.service;

import com.poly.assignment.entity.NhanVien;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NhanVienService {

    List<NhanVien> listNhanVien = new ArrayList<>();

    public NhanVienService() {
    }

    public List<NhanVien> findAll() {
        return listNhanVien;
    }

    public NhanVien findById(String id) {
        for (NhanVien nhanVien: listNhanVien) {
            if (nhanVien.getId().equals(id)) {
                return nhanVien;
            }
        }

        return null;
    }

    public List<NhanVien> findByKey(String key) {
        List<NhanVien> result = new ArrayList<>();
        for (NhanVien nhanVien: listNhanVien) {
            if (nhanVien.getMaNV().toLowerCase().contains(key.toLowerCase()) || nhanVien.getTen().toLowerCase().contains(key.toLowerCase()) || nhanVien.getTenDangNhap().toLowerCase().contains(key.toLowerCase())) {
                result.add(nhanVien);
            }
        }

        return result;
    }

    public void create(NhanVien nhanVien) {
        listNhanVien.add(nhanVien);
    }

    public void update(NhanVien nhanVien) {
        for (int i = 0; i < listNhanVien.size(); i++) {
            if (listNhanVien.get(i).getId().equals(nhanVien.getId())) {
                listNhanVien.set(i, nhanVien);
            }
        }
    }

    public void delete(Integer id) {
        List<NhanVien> deList = new ArrayList<>();
        for (int i = 0; i < listNhanVien.size(); i++) {
            if (listNhanVien.get(i).getId() == id) {
                deList.add(listNhanVien.get(i));
            }
        }

        listNhanVien.removeAll(deList);
    }

}
