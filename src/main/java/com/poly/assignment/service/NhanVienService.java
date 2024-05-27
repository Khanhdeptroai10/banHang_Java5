package com.poly.assignment.service;

import com.poly.assignment.entity.NhanVien;
import com.poly.assignment.util.PageUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class NhanVienService {

    List<NhanVien> listNhanVien = new ArrayList<>();

    public NhanVienService() {
        listNhanVien.add(new NhanVien("1", "NV01", "Nguyen Van A", "a12345", "123456", false, true));
        listNhanVien.add(new NhanVien("2", "NV02", "Nguyen Thi B", "b12345", "123456", false, true));
        listNhanVien.add(new NhanVien("3", "NV03", "Nguyen Van C", "c12345", "123456", false,  true));
        listNhanVien.add(new NhanVien("admin", "admin", "admin", "admin", "admin", true, true));
        listNhanVien.add(new NhanVien("4", "NV04", "Nguyen Thi D", "d12345", "123456", false, true));
        listNhanVien.add(new NhanVien("5", "NV05", "Nguyen Van E", "e12345", "123456", false, true));
        listNhanVien.add(new NhanVien("6", "NV06", "Nguyen Van F", "f12345", "123456", false, false));
        listNhanVien.add(new NhanVien("7", "NV07", "Nguyen Van G", "g12345", "123456", false, true));
        listNhanVien.add(new NhanVien("8", "NV0", "Nguyen Van H", "h12345", "123456", false, false));
        listNhanVien.add(new NhanVien("9", "NV09", "Nguyen Van I", "i12345", "123456", false, true));
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
        nhanVien.setId(UUID.randomUUID().toString());
        listNhanVien.add(nhanVien);
    }

    public void update(NhanVien nhanVien) {
        for (int i = 0; i < listNhanVien.size(); i++) {
            if (listNhanVien.get(i).getId().equals(nhanVien.getId())) {
                listNhanVien.set(i, nhanVien);
            }
        }
    }

    public void delete(String id) {
        List<NhanVien> deList = new ArrayList<>();
        for (int i = 0; i < listNhanVien.size(); i++) {
            if (listNhanVien.get(i).getId().equals(id)) {
                deList.add(listNhanVien.get(i));
            }
        }

        listNhanVien.removeAll(deList);
    }

}
