package com.poly.assignment.controller;

import com.poly.assignment.entity.*;
import com.poly.assignment.service.GioHangService;
import com.poly.assignment.service.KhachHangService;
import com.poly.assignment.service.SanPhamChiTietService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.*;

@Controller
@RequiredArgsConstructor
public class GioHangController {

    private final GioHangService gioHangService;

    private final SanPhamChiTietService sanPhamChiTietService;

    private final KhachHangService khachHangService;

    //let create model attribute below to save order state

    @GetMapping("/cart")
    public String cartPage(@ModelAttribute("hoaDon") HoaDon hoaDon, Model model) {
        if (Auth.isLoggedIn() == false || Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        model.addAttribute("cart", gioHangService.findAll());
        return "/cart.jsp";
    }

    @GetMapping("/add-to-cart")
    public String addToCart(@RequestParam("pid") String pid,
                            @RequestParam("pdid") String pdid) {
        if (Auth.isLoggedIn() == false || Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        if (pdid != null) {
            SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietService.findById(pdid);

            gioHangService.addToCart(new GioHang(UUID.randomUUID().toString(), sanPhamChiTiet, 1));
        }
        return "redirect:/product-" + pid + "/details";
    }

    @GetMapping("/decrease-quantity-in-cart-item")
    public String decreaseQuantityInCart(@RequestParam("cid") String cid) {
        if (Auth.isLoggedIn() == false || Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        if (cid != null && !cid.equals(""))
            gioHangService.decreaseQuantityInCart(cid);
        return "redirect:/checkout";
    }

    @GetMapping("/increase-quantity-in-cart-item")
    public String increaseQuantityInCart(@RequestParam("cid") String cid) {
        if (Auth.isLoggedIn() == false || Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        if (cid != null && !cid.equals(""))
            gioHangService.increaseQuantityInCart(cid);

        return "redirect:/checkout";

    }

    @GetMapping("/delete-item-in-cart")
    public String deleteItemInCart(@RequestParam("pdid") String pdid) {
        if (Auth.isLoggedIn() == false || Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        if (pdid != null && !pdid.equals(""))
            gioHangService.deleteItemInCart(pdid);
        return "redirect:/cart";
    }

    @GetMapping("/clear-cart")
    public String clearCart() {
        if (Auth.isLoggedIn() == false || Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        gioHangService.deleteAll();
        return "redirect:/cart";
    }

    @ModelAttribute("khachHangList")
    public List<KhachHang> getKhachHangList() {
        return khachHangService.findAll();
    }

    @ModelAttribute("status")
    public Map<Boolean, String> getStatus() {
        Map<Boolean, String> map = new LinkedHashMap<>();
        map.put(true, "Success");
        map.put(false, "Canceled");
        return map;
    }

}
