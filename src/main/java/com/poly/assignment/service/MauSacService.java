package com.poly.assignment.service;

import com.poly.assignment.entity.MauSac;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MauSacService {

    List<MauSac> listMauSac = new ArrayList<>();

    public MauSacService() {
    }

    public List<MauSac> findAll() {
        return listMauSac;
    }

    public MauSac findById(Integer id) {
        for (MauSac mauSac: listMauSac) {
            if (mauSac.getId() == id) {
                return mauSac;
            }
        }

        return null;
    }

    public List<MauSac> findByKey(String key) {
        List<MauSac> result = new ArrayList<>();
        for (MauSac mauSac: listMauSac) {
            if (mauSac.getMaMS().toLowerCase().contains(key.toLowerCase()) || mauSac.getTen().toLowerCase().contains(key.toLowerCase())) {
                result.add(mauSac);
            }
        }

        return result;
    }

    public void create(MauSac mauSac) {
        listMauSac.add(mauSac);
    }

    public void update(MauSac mauSac) {
        for (int i = 0; i < listMauSac.size(); i++) {
            if (listMauSac.get(i).getId().equals(mauSac.getId())) {
                listMauSac.set(i, mauSac);
            }
        }
    }

    public void delete(String id) {
        List<MauSac> deList = new ArrayList<>();
        for (int i = 0; i < listMauSac.size(); i++) {
            if (listMauSac.get(i).getId().equals(id)) {
                deList.add(listMauSac.get(i));
            }
        }

        listMauSac.removeAll(deList);
    }

}
