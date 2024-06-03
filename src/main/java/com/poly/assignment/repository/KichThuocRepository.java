package com.poly.assignment.repository;

import com.poly.assignment.entity.KichThuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KichThuocRepository extends JpaRepository<KichThuoc, Integer> {

    @Query("select e from KichThuoc e where e.maKT like %?1% or e.ten like %?1%")
    List<KichThuoc> findByKey(String key);

}
