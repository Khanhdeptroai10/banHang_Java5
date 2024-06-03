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
@Table(name = "employees")
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_nhan_vien")
    @NotBlank(message = "Vui long nhap ma nhan vien")
    private String maNV;

    @Column(name = "ten")
    @NotBlank(message = "Vui long nhap ten nhan vien")
    private String ten;

    @Column(name = "ten_dang_nhap")
    @NotBlank(message = "Vui long nhap ten dang nhap")
    private String tenDangNhap;

    @Column(name = "mat_khau")
    @NotBlank(message = "Vui long nhap mat khau")
    private String matKhau;

    @Column(name = "vai_tro")
    @NotNull(message = "Vui long chon vai tro")
    private Boolean vaiTro;

    @Column(name = "trang_thai")
    @NotNull(message = "Vui long chon trang thai")
    private Boolean trangThai;

}
