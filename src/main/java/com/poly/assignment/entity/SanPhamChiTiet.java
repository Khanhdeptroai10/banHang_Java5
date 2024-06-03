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
    @NotBlank(message = "Vui lòng nhập mã sản phẩm chi tiết")
    private String maSPCT;

    @Column(name = "ten")
    @NotBlank(message = "Vui lòng nhập tên sản phẩm chi tiết")
    private String ten;

    @Column(name = "soLuong")
    @Min(value = 1, message = "Vui lòng nhập số lượng > 0")
    @NotNull(message = "Vui lòng nhập số lượng")
    private Integer soLuong;

    @Column(name = "don_gia")
    @Min(value = 1, message = "Vui lòng nhập đơn giá > 0")
    @NotNull(message = "Vui lòng nhập đơn giá")
    private Double donGia;

    @Column(name = "hinh_anh")
    private String hinhAnh;

    @Column(name = "trang_thai")
    @NotNull(message = "Vui lòng chọn trạng thái")
    private Boolean trangThai;

    @ManyToOne
    @JoinColumn(name = "size_id", referencedColumnName = "id")
    @NotNull(message = "Vui lòng chọn kích thước")
    private KichThuoc kichThuoc;

    @ManyToOne
    @JoinColumn(name = "color_id", referencedColumnName = "id")
    @NotNull(message = "Vui lòng chọn màu sắc")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @NotNull(message = "Vui lòng chọn sản phẩm")
    private SanPham sanPham;

}
