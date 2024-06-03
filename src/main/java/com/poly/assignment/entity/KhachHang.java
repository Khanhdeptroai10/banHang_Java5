package com.poly.assignment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

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
    @NotBlank(message = "Vui lòng nhập mã khách hàng")
    private String maKH;

    @Column(name = "ten")
    @NotBlank(message = "Vui lòng nhập tên khách hàng")
    private String ten;

    @Column(name = "sdt")
    @Pattern(regexp = "^0[0-9]{9}+", message = "Nhập số điện thoại bắt đầu bằng 0, gồm 10 số và không chứa chữ")
    private String sdt;

    @Column(name = "trang_thai")
    @NotNull(message = "Vui long chon trang thai")
    private Boolean trangThai;

}
