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
@Table(name = "colors")
public class MauSac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_mau_sac")
    @NotBlank(message = "Vui long nhap ma mau sac")
    private String maMS;

    @Column(name = "ten")
    @NotBlank(message = "Vui long nhap ten mau sac")
    private String ten;

    @Column(name = "trang_thai")
    @NotNull(message = "Vui long chon trang thai")
    private Boolean trangThai;

}
