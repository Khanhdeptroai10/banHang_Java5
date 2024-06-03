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
@Table(name = "sizes")
public class KichThuoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_kich_thuoc")
    @NotBlank(message = "Vui lòng nhập mã kích thước")
    private String maKT;

    @Column(name = "ten")
    @NotBlank(message = "Vui lòng nhập tên kích thước")
    private String ten;

    @Column(name = "trang_thai")
    @NotNull(message = "Vui lòng chọn trạng thái")
    private Boolean trangThai;

}
