package com.poly.assignment.controller;

import com.poly.assignment.entity.*;
import com.poly.assignment.service.GioHangService;
import com.poly.assignment.service.HoaDonChiTietService;
import com.poly.assignment.service.HoaDonService;
import com.poly.assignment.service.KhachHangService;
import com.poly.assignment.util.PageUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class HoaDonController {

    private final HoaDonService hoaDonService;

    private final HoaDonChiTietService hoaDonChiTietService;

    private final KhachHangService khachHangService;

    private final GioHangService gioHangService;

    @GetMapping("/checkout")
    public String checkoutPage(Model model) {
        if (Auth.isLoggedIn() == false || Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        model.addAttribute("carts", gioHangService.findAll());
        return "/checkout.jsp";
    }

    @GetMapping("/orders/table")
    public String getOrders(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                            Model model) {
        if (Auth.isLoggedIn() == false || Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        Page<HoaDon> hoaDonPage = PageUtil.createPage(hoaDonService.findAll(), page, pageSize);
        model.addAttribute("orders", hoaDonPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", hoaDonPage.getTotalPages());
        return "/orders-table.jsp";
    }

    @GetMapping("/orders/search")
    public List<HoaDon> findByKey(@RequestParam("key") String key) {
        return hoaDonService.findByKey(key);
    }

    @ModelAttribute("khachHangList")
    public List<KhachHang> getKhachHangList() {
        return khachHangService.findAll();
    }

//    @ModelAttribute("status")
//    public Map<Boolean, String> getStatus() {
//        Map<Boolean, String> map = new LinkedHashMap<>();
//        map.put(true, "Success");
//        map.put(false, "Canceled");
//        return map;
//    }

    @PostMapping("/orders/create")
    public String createOrder(@Valid @ModelAttribute("hoaDon") HoaDon hoaDon,
                              BindingResult result,
                              @RequestParam(value = "id", required = false) String id,
                              Model model) {
        if (Auth.isLoggedIn() == false || Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }

        if (result.hasErrors()) {
            model.addAttribute("cart", gioHangService.findAll());
            return "/cart.jsp";
        }

        hoaDon.setKhachHang(khachHangService.findById(hoaDon.getKhachHang().getId()));
        hoaDon.setNhanVien(Auth.getLoggedInNhanVien());
        hoaDon.setTrangThai(true);

        if (id != null && !id.isBlank()) {
            hoaDon.setId(id);
            hoaDonService.update(hoaDon);
        } else {
            HoaDon hoaDon1 = hoaDonService.create(hoaDon);
            gioHangService.findAll().forEach(gioHang -> {
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                hoaDonChiTiet.setHoaDon(hoaDon1);
                hoaDonChiTiet.setSanPhamChiTiet(gioHang.getSanPhamChiTiet());
                hoaDonChiTiet.setDonGia(gioHang.getSanPhamChiTiet().getDonGia());
                hoaDonChiTiet.setSoLuong(gioHang.getQuantity());
                hoaDonChiTiet.setTrangThai(true);
                hoaDonChiTietService.create(hoaDonChiTiet);
            });
        }

        return "redirect:/orders/table";
    }

    @GetMapping("/orders/cancel")
    public String cancelOrder(@RequestParam("id") String id,
                              @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                              Model model) {
        if (Auth.isLoggedIn() == false || Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }

        if (Auth.getLoggedInNhanVien().getVaiTro() == false) {
            model.addAttribute("error", "You don't have permission!");
            Page<HoaDon> hoaDonPage = PageUtil.createPage(hoaDonService.findAll(), page, pageSize);
            model.addAttribute("orders", hoaDonPage.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("totalPages", hoaDonPage.getTotalPages());
            return "/orders-table.jsp";
        }

        hoaDonService.cancel(id);

        hoaDonChiTietService.findAllHoaDonChiTietByHoaDon(id).forEach(hoaDonChiTiet ->
                hoaDonChiTietService.cancel(hoaDonChiTiet.getId())
        );

        return "redirect:/orders/table";
    }

}
