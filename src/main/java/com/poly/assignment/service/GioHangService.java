package com.poly.assignment.service;

import com.poly.assignment.entity.GioHang;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GioHangService {

    List<GioHang> gioHangList = new ArrayList<>();

    public List<GioHang> findAll() {
        return gioHangList;
    }

    public GioHang findById(List<GioHang> gioHangList, String cid) {
        return gioHangList.stream()
                .filter(item -> item.getId().equals(cid))
                .findFirst().orElse(null);
    }

    public GioHang findByProductDetailId(Integer pdid) {
        return gioHangList.stream()
                .filter(item -> item.getSanPhamChiTiet().getId() == pdid)
                .findFirst().orElse(null);
    }

    public void addToCart(GioHang gioHang) {
        GioHang gioHangResult = findByProductDetailId(gioHang.getSanPhamChiTiet().getId());
        if (gioHangResult != null) {
            gioHangResult.setQuantity(gioHangResult.getQuantity() + 1);
        } else gioHangList.add(gioHang);
    }

    public void decreaseQuantityInCart(String cid) {
        GioHang gioHang = findById(gioHangList, cid);
        if (gioHang != null)
            gioHang.setQuantity(gioHang.getQuantity() - 1);
    }

    public void increaseQuantityInCart(String cid) {
        GioHang gioHang = findById(gioHangList, cid);
        if (gioHang != null)
            gioHang.setQuantity(gioHang.getQuantity() + 1);
    }

    public void deleteItemInCart(Integer pdid) {
        GioHang gioHangResult = findByProductDetailId(pdid);
        if (gioHangResult != null)
            gioHangList.remove(gioHangResult);
    }

    public void deleteAll() {
        gioHangList.removeAll(gioHangList);
    }

    public double calculator() {
        double totalCost = 0.0;

        for (GioHang gioHang : gioHangList) {
            int quantity = gioHang.getQuantity();
            double price = gioHang.getSanPhamChiTiet().getDonGia();

            totalCost += price * quantity;
        }

        return totalCost;
    }

}
