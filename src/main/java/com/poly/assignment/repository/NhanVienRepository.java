package com.poly.assignment.repository;

import com.poly.assignment.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {

    @Query("select e from NhanVien e where e.maNV like %?1% or e.ten like %?1% or e.tenDangNhap like %?1%")
    List<NhanVien> findByKey(String key);

}
