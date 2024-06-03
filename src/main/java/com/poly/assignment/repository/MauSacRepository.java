package com.poly.assignment.repository;

import com.poly.assignment.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, Integer> {

    @Query("select e from MauSac e where e.maMS like %?1% or e.ten like %?1%")
    List<MauSac> findByKey(String key);

}
