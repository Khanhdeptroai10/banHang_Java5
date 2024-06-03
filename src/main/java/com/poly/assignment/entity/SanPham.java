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
@Table(name = "products")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_san_pham")
    @NotBlank(message = "Vui lòng nhập mã sản phẩm")
    private String maSP;

    @Column(name = "ten")
    @NotBlank(message = "Vui lòng chọn tên sản phẩm")
    private String ten;

    @Column(name = "hinh_anh")
    private String hinhAnh;

    @Column(name = "trang_thai")
    @NotNull(message = "Vui lòng chọn trạng thái")
    private Boolean trangThai;

}
