package com.poly.assignment.repository;

import com.poly.assignment.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {

    @Query("select e from KhachHang e where e.maKH like %?1% or e.ten like %?1% or e.sdt like %?1%")
    List<KhachHang> findByKey(String key);

}
