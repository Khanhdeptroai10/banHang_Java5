package com.poly.assignment.service;

import com.poly.assignment.entity.SanPhamChiTiet;
import com.poly.assignment.repository.SanPhamChiTietRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SanPhamChiTietService {

    private final SanPhamChiTietRepository sanPhamChiTietRepository;

    private final KichThuocService kichThuocService;

    private final MauSacService mauSacService;

    private final SanPhamService sanPhamService;

    private final FileUploadService fileUploadService;

    public List<SanPhamChiTiet> findAll() {
        return sanPhamChiTietRepository.findAll();
    }

    public SanPhamChiTiet findById(Integer id) {
        return sanPhamChiTietRepository.findById(id).get();
    }

    public List<SanPhamChiTiet> findAllSanPhamChiTietBySanPham(Integer id) {
        return sanPhamChiTietRepository.findSanPhamChiTietBySanPham(sanPhamService.findById(id));
    }

    public List<SanPhamChiTiet> findByKey(String key) {
        return sanPhamChiTietRepository.findByKey(key);
    }

    public void create(SanPhamChiTiet sanPhamChiTiet, MultipartFile file) throws IOException {
        sanPhamChiTiet.setKichThuoc(kichThuocService.findById(sanPhamChiTiet.getKichThuoc().getId()));
        sanPhamChiTiet.setMauSac(mauSacService.findById(sanPhamChiTiet.getMauSac().getId()));
        sanPhamChiTiet.setSanPham(sanPhamService.findById(sanPhamChiTiet.getSanPham().getId()));
        sanPhamChiTiet.setHinhAnh(fileUploadService.uploadFile(file));
        sanPhamChiTietRepository.save(sanPhamChiTiet);
    }

    public void update(SanPhamChiTiet sanPhamChiTiet, MultipartFile file) throws IOException {
        sanPhamChiTiet.setKichThuoc(kichThuocService.findById(sanPhamChiTiet.getKichThuoc().getId()));
        sanPhamChiTiet.setMauSac(mauSacService.findById(sanPhamChiTiet.getMauSac().getId()));
        sanPhamChiTiet.setSanPham(sanPhamService.findById(sanPhamChiTiet.getSanPham().getId()));
        sanPhamChiTiet.setHinhAnh(fileUploadService.uploadFile(file));
        sanPhamChiTietRepository.save(sanPhamChiTiet);
    }

    public void delete(Integer id) {
        sanPhamChiTietRepository.deleteById(id);
    }

}
