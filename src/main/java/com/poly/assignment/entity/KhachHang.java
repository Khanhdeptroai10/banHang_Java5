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
public class KhachHang {

    private String id;

    @NotBlank(message = "Vui long nhap ma khach hang")
    private String maKH;

    @NotBlank(message = "Vui long nhap ten khach hang")
    private String ten;

    @NotBlank(message = "Vui long nhap so dien thoai")
    private String sdt;

    @NotNull(message = "Vui long chon trang thai")
    private Boolean trangThai;

}
