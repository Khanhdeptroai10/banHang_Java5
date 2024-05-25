package com.poly.assignment.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPham {

    private String id;

    @NotBlank(message = "Vui long nhap ma san pham")
    private String maSP;

    @NotBlank(message = "Vui long nhap ten san pham")
    private String ten;

    private String hinhAnh;

    @NotNull(message = "Vui long chon trang thai")
    private Boolean trangThai;

}
