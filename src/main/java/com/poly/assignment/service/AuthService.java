package com.poly.assignment.service;

import com.poly.assignment.entity.NhanVien;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final NhanVienService nhanVienService;

    public NhanVien login(String tenDangNhap, String matKhau) {
        for (NhanVien nhanVien : nhanVienService.findAll()) {
            if (nhanVien.getTenDangNhap().equals(tenDangNhap) && nhanVien.getMatKhau().equals(matKhau)) {
                return nhanVien;
            }
        }
        return null;
    }

}
