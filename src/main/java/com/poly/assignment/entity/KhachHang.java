package com.poly.assignment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_khach_hang")
    @NotBlank(message = "Vui long nhap ma khach hang")
    private String maKH;

    @Column(name = "ten")
    @NotBlank(message = "Vui long nhap ten khach hang")
    private String ten;

    @Column(name = "sdt")
    @NotBlank(message = "Vui long nhap so dien thoai")
    private String sdt;

    @Column(name = "trang_thai")
    @NotNull(message = "Vui long chon trang thai")
    private Boolean trangThai;

}
