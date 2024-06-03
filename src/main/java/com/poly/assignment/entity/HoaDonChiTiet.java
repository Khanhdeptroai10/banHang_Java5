package com.poly.assignment.entity;

import jakarta.persistence.*;
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
@Table(name = "invoice_details")
public class HoaDonChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "so_luong")
    @NotNull(message = "Vui long nhap so luong")
    private Integer soLuong;

    @Column(name = "don_gia")
    @NotNull(message = "Vui long nhap don gia")
    private Double donGia;

    @Column(name = "trang_thai")
    @NotNull(message = "Vui long chon trang thai")
    private Boolean trangThai;

    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    @NotNull(message = "Vui long chon hoa don")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "product_detail_id", referencedColumnName = "id")
    @NotNull(message = "Vui long chon san pham chi tiet")
    private SanPhamChiTiet sanPhamChiTiet;

}
