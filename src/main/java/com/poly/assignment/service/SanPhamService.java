package com.poly.assignment.service;

import com.poly.assignment.entity.SanPham;
import com.poly.assignment.repository.SanPhamChiTietRepository;
import com.poly.assignment.repository.SanPhamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SanPhamService {

    private final SanPhamRepository sanPhamRepository;

    private final SanPhamChiTietRepository sanPhamChiTietRepository;

    private final FileUploadService fileUploadService;

    public List<SanPham> findAll() {
        return sanPhamRepository.findAll();
    }

    public SanPham findById(Integer id) {
        return sanPhamRepository.findById(id).get();
    }

    public List<SanPham> findByKey(String key) {
        return sanPhamRepository.findBykey(key);
    }

    public void create(SanPham sanPham, MultipartFile file) throws IOException {
        sanPham.setHinhAnh(fileUploadService.uploadFile(file));
        sanPhamRepository.save(sanPham);
    }

    public void update(SanPham sanPham, MultipartFile file) throws IOException {
        sanPham.setHinhAnh(fileUploadService.uploadFile(file));
        sanPhamRepository.save(sanPham);
    }

    public void delete(Integer id) {
        sanPhamChiTietRepository.findSanPhamChiTietBySanPham(findById(id)).forEach(sanPhamChiTiet ->
            sanPhamChiTietRepository.deleteById(sanPhamChiTiet.getId())
        );

        sanPhamRepository.deleteById(id);
    }

}
