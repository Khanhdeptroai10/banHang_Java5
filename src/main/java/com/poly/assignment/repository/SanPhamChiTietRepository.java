package com.poly.assignment.repository;

import com.poly.assignment.entity.SanPham;
import com.poly.assignment.entity.SanPhamChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamChiTietRepository extends JpaRepository<SanPhamChiTiet, Integer> {

    List<SanPhamChiTiet> findSanPhamChiTietBySanPham(SanPham sanPham);

    @Query("""
            select e 
            from SanPhamChiTiet e
            where e.maSPCT like %?1% or 
                  e.ten like %?1% or 
                  e.sanPham.ten like %?1% or 
                  e.kichThuoc.ten like %?1% or 
                  e.mauSac.ten like %?1% or 
                  e.sanPham.maSP like %?1%
            """)
    List<SanPhamChiTiet> findByKey(String key);
}
