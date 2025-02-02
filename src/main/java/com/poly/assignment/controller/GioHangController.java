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

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class GioHangController {

    private final GioHangService gioHangService;

    private final SanPhamChiTietService sanPhamChiTietService;

    private final KhachHangService khachHangService;

    @GetMapping("/cart")
    public String cartPage(@ModelAttribute("hoaDon") HoaDon hoaDon, Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        model.addAttribute("cart", gioHangService.findAll());
        model.addAttribute("totalCost", gioHangService.calculator());
        return "/cart.jsp";
    }

    @GetMapping("/add-to-cart")
    public String addToCart(@RequestParam("pid") Integer pid,
                            @RequestParam("pdid") Integer pdid,
                            Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        if (pdid != null) {
            SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietService.findById(pdid);

            gioHangService.addToCart(new GioHang(UUID.randomUUID().toString(), sanPhamChiTiet, 1));
        }
        model.addAttribute("totalCost", gioHangService.calculator());
        return "redirect:/product-" + pid + "/details";
    }

    @GetMapping("/decrease-quantity-in-cart-item")
    public String decreaseQuantityInCart(@RequestParam("cid") String cid, Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        if (cid != null && !cid.equals(""))
            gioHangService.decreaseQuantityInCart(cid);
        model.addAttribute("totalCost", gioHangService.calculator());
        return "redirect:/cart";
    }

    @GetMapping("/increase-quantity-in-cart-item")
    public String increaseQuantityInCart(@RequestParam("cid") String cid, Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        if (cid != null && !cid.equals(""))
            gioHangService.increaseQuantityInCart(cid);
        model.addAttribute("totalCost", gioHangService.calculator());
        return "redirect:/cart";
    }

    @GetMapping("/delete-item-in-cart")
    public String deleteItemInCart(@RequestParam("pdid") Integer pdid, Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        if (pdid != null && !pdid.equals(""))
            gioHangService.deleteItemInCart(pdid);
        model.addAttribute("totalCost", gioHangService.calculator());
        return "redirect:/cart";
    }

    @GetMapping("/clear-cart")
    public String clearCart() {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        gioHangService.deleteAll();
        return "redirect:/cart";
    }

    @ModelAttribute("khachHangList")
    public List<KhachHang> getKhachHangList() {
        return khachHangService.findAll();
    }

}
