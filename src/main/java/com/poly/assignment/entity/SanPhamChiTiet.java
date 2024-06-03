package com.poly.assignment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
@Table(name = "product_details")
public class SanPhamChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_san_pham_chi_tiet")
    @NotBlank(message = "Vui long nhap ma san pham chi tiet")
    private String maSPCT;

    @Column(name = "ten")
    @NotBlank(message = "Vui long nhap ten san pham chi tiet")
    private String ten;

    @Column(name = "soLuong")
    @Min(value = 1, message = "Vui long nhap so luong > 0")
    @NotNull(message = "Vui long nhap so luong")
    private Integer soLuong;

    @Column(name = "don_gia")
    @Min(value = 1, message = "Vui long nhap don gia > 0")
    @NotNull(message = "Vui long nhap don gia")
    private Double donGia;

    @Column(name = "hinh_anh")
    private String hinhAnh;

    @Column(name = "trang_thai")
    @NotNull(message = "Vui long chon trang thai")
    private Boolean trangThai;

    @ManyToOne
    @JoinColumn(name = "size_id", referencedColumnName = "id")
    @NotNull(message = "Vui long chon kich thuoc")
    private KichThuoc kichThuoc;

    @ManyToOne
    @JoinColumn(name = "color_id", referencedColumnName = "id")
    @NotNull(message = "Vui long chon mau sac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @NotNull(message = "Vui long chon san pham")
    private SanPham sanPham;

}
