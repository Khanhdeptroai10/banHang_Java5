package com.poly.assignment.repository;

import com.poly.assignment.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {

    @Query("""
            select e 
            from HoaDon e
            where e.nhanVien.maNV like %?1% or 
                  e.nhanVien.ten like %?1% or 
                  e.khachHang.maKH like %?1% or 
                  e.khachHang.ten like %?1%
            """)
    List<HoaDon> findByKey(String key);

}
