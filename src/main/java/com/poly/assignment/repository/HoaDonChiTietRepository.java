package com.poly.assignment.repository;

import com.poly.assignment.entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Integer> {

    @Query("""
            select e 
            from HoaDonChiTiet e 
            where e.hoaDon.id = ?1
            """)
    List<HoaDonChiTiet> findByKey(Integer key);

}
