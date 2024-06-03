package com.poly.assignment.service;

import com.poly.assignment.entity.HoaDonChiTiet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HoaDonChiTietService {

    List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();

    public HoaDonChiTietService() {
    }

    public List<HoaDonChiTiet> findAll() {
        return listHoaDonChiTiet;
    }

    public HoaDonChiTiet findById(String id) {
        for (HoaDonChiTiet hoaDonChiTiet: listHoaDonChiTiet) {
            if (hoaDonChiTiet.getId().equals(id)) {
                return hoaDonChiTiet;
            }
        }

        return null;
    }

    public List<HoaDonChiTiet> findByKey(String key) {
        List<HoaDonChiTiet> result = new ArrayList<>();
        for (HoaDonChiTiet hoaDonChiTiet: listHoaDonChiTiet) {
            if (hoaDonChiTiet.getHoaDon().getId().toString().contains(key.toLowerCase()) || hoaDonChiTiet.getId().toString().contains(key.toLowerCase())) {
                result.add(hoaDonChiTiet);
            }
        }

        return result;
    }

    public List<HoaDonChiTiet> findAllHoaDonChiTietByHoaDon(Integer id) {
        List<HoaDonChiTiet> result = new ArrayList<>();
        for (HoaDonChiTiet hoaDonChiTiet: listHoaDonChiTiet) {
            if (hoaDonChiTiet.getHoaDon().getId() == id) {
                result.add(hoaDonChiTiet);
            }
        }

        return result;
    }

    public void create(HoaDonChiTiet hoaDonChiTiet) {
        listHoaDonChiTiet.add(hoaDonChiTiet);
    }

    public void update(HoaDonChiTiet hoaDonChiTiet) {
        for (int i = 0; i < listHoaDonChiTiet.size(); i++) {
            if (listHoaDonChiTiet.get(i).getId().equals(hoaDonChiTiet.getId())) {
                listHoaDonChiTiet.set(i, hoaDonChiTiet);
            }
        }
    }

    public void cancel(String id) {
        findById(id).setTrangThai(false);
    }

}
