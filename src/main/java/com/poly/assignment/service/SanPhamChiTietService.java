package com.poly.assignment.service;

import com.poly.assignment.entity.SanPhamChiTiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SanPhamChiTietService {

    List<SanPhamChiTiet> listSanPhamChiTiet = new ArrayList<>();

    @Autowired
    KichThuocService kichThuocService;

    @Autowired
    MauSacService mauSacService;

    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    FileUploadService fileUploadService;

    public SanPhamChiTietService() {
    }

    public List<SanPhamChiTiet> findAll() {
        return listSanPhamChiTiet;
    }

    public SanPhamChiTiet findById(String id) {
        for (SanPhamChiTiet sanPhamChiTiet : listSanPhamChiTiet) {
            if (sanPhamChiTiet.getId().equals(id)) {
                return sanPhamChiTiet;
            }
        }

        return null;
    }

    public List<SanPhamChiTiet> findAllSanPhamChiTietBySanPham(Integer id) {
        List<SanPhamChiTiet> result = new ArrayList<>();
        for (SanPhamChiTiet sanPhamChiTiet : listSanPhamChiTiet) {
            if (sanPhamChiTiet.getSanPham().getId() == id) {
                result.add(sanPhamChiTiet);
            }
        }

        return result;
    }

    public List<SanPhamChiTiet> findByKey(String key) {
        List<SanPhamChiTiet> result = new ArrayList<>();
        for (SanPhamChiTiet sanPhamChiTiet : listSanPhamChiTiet) {
            if (sanPhamChiTiet.getMaSPCT().toLowerCase().contains(key.toLowerCase()) ||
                    sanPhamChiTiet.getMauSac().getTen().toLowerCase().contains(key.toLowerCase()) ||
                    sanPhamChiTiet.getKichThuoc().getTen().toLowerCase().contains(key.toLowerCase()) ||
                    sanPhamChiTiet.getSanPham().getMaSP().toLowerCase().contains(key.toLowerCase()) ||
                    sanPhamChiTiet.getSanPham().getTen().toLowerCase().contains(key.toLowerCase())) {
                result.add(sanPhamChiTiet);
            }
        }

        return result;
    }

    public void create(SanPhamChiTiet sanPhamChiTiet, MultipartFile file) throws IOException {
        sanPhamChiTiet.setKichThuoc(kichThuocService.findById(sanPhamChiTiet.getKichThuoc().getId()));
        sanPhamChiTiet.setMauSac(mauSacService.findById(sanPhamChiTiet.getMauSac().getId()));
        sanPhamChiTiet.setSanPham(sanPhamService.findById(sanPhamChiTiet.getSanPham().getId()));
        sanPhamChiTiet.setHinhAnh(fileUploadService.uploadFile(file));
        listSanPhamChiTiet.add(sanPhamChiTiet);
    }

    public void update(SanPhamChiTiet sanPhamChiTiet, MultipartFile file) throws IOException {
        for (int i = 0; i < listSanPhamChiTiet.size(); i++) {
            if (listSanPhamChiTiet.get(i).getId().equals(sanPhamChiTiet.getId())) {
                sanPhamChiTiet.setKichThuoc(kichThuocService.findById(sanPhamChiTiet.getKichThuoc().getId()));
                sanPhamChiTiet.setMauSac(mauSacService.findById(sanPhamChiTiet.getMauSac().getId()));
                sanPhamChiTiet.setSanPham(sanPhamService.findById(sanPhamChiTiet.getSanPham().getId()));
                sanPhamChiTiet.setHinhAnh(fileUploadService.uploadFile(file));
                listSanPhamChiTiet.set(i, sanPhamChiTiet);
            }
        }
    }

    public void delete(Integer id) {
        List<SanPhamChiTiet> deList = new ArrayList<>();
        for (int i = 0; i < listSanPhamChiTiet.size(); i++) {
            if (listSanPhamChiTiet.get(i).getId() == id) {
                deList.add(listSanPhamChiTiet.get(i));
            }
        }

        listSanPhamChiTiet.removeAll(deList);
    }

}
