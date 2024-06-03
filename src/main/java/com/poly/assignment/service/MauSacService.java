package com.poly.assignment.service;

import com.poly.assignment.entity.MauSac;
import com.poly.assignment.repository.MauSacRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MauSacService {

    private final MauSacRepository mauSacRepository;

    public List<MauSac> findAll() {
        return mauSacRepository.findAll();
    }

    public MauSac findById(Integer id) {
        return mauSacRepository.findById(id).get();
    }

    public List<MauSac> findByKey(String key) {
        return mauSacRepository.findByKey(key);
    }

    public void create(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }

    public void update(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }

    public void delete(Integer id) {
        mauSacRepository.deleteById(id);
    }

}
