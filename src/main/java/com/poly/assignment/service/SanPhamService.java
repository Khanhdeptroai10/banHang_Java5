package com.poly.assignment.service;

import com.poly.assignment.entity.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SanPhamService {

    List<SanPham> listSanPham = new ArrayList<>();

    @Autowired
    FileUploadService fileUploadService;

    public SanPhamService() {
    }

    public List<SanPham> findAll() {
        return listSanPham;
    }

    public SanPham findById(Integer id) {
        for (SanPham sanPham: listSanPham) {
            if (sanPham.getId() == id) {
                return sanPham;
            }
        }

        return null;
    }

    public List<SanPham> findByKey(String key) {
        List<SanPham> result = new ArrayList<>();
        for (SanPham sanPham: listSanPham) {
            if (sanPham.getMaSP().toLowerCase().contains(key.toLowerCase()) || sanPham.getTen().toLowerCase().contains(key.toLowerCase())) {
                result.add(sanPham);
            }
        }

        return result;
    }

    public void create(SanPham sanPham, MultipartFile file) throws IOException {
        sanPham.setHinhAnh(fileUploadService.uploadFile(file));
        listSanPham.add(sanPham);
    }

    public void update(SanPham sanPham, MultipartFile file) throws IOException {
        for (int i = 0; i < listSanPham.size(); i++) {
            if (listSanPham.get(i).getId().equals(sanPham.getId())) {
                sanPham.setHinhAnh(fileUploadService.uploadFile(file));
                listSanPham.set(i, sanPham);
            }
        }
    }

    public void delete(Integer id) {
        List<SanPham> deList = new ArrayList<>();
        for (int i = 0; i < listSanPham.size(); i++) {
            if (listSanPham.get(i).getId() == id) {
                deList.add(listSanPham.get(i));
            }
        }

        listSanPham.removeAll(deList);
    }

}
