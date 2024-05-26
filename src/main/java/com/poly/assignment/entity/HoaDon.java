package com.poly.assignment.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDon {

    private String id;

    private NhanVien nhanVien;

    @NotNull(message = "Vui long chon khach hang")
    private KhachHang khachHang;

    private LocalDateTime ngayMuaHang;

    private Boolean trangThai;

}
