package com.poly.assignment.repository;

import com.poly.assignment.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {

    @Query("select e from SanPham e where e.maSP like %?1% or e.ten like %?1%")
    List<SanPham> findBykey(String key);

}
