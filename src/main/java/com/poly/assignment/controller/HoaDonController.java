package com.poly.assignment.controller;

import com.poly.assignment.entity.Auth;
import com.poly.assignment.entity.HoaDon;
import com.poly.assignment.entity.KhachHang;
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
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class HoaDonController {

    private final HoaDonService hoaDonService;

    private final KhachHangService khachHangService;

    private final GioHangService gioHangService;

    private final HoaDonChiTietService hoaDonChiTietService;

    @GetMapping("/checkout")
    public String checkoutPage(Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        model.addAttribute("carts", gioHangService.findAll());
        return "/checkout.jsp";
    }

    @GetMapping("/orders/table")
    public String getOrders(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                            Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        Page<HoaDon> hoaDonPage = PageUtil.createPage(hoaDonService.findAll(), page, pageSize);
        model.addAttribute("orders", hoaDonPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", hoaDonPage.getTotalPages());
        return "/orders-table.jsp";
    }

    @GetMapping("/orders/table/search")
    public String findByKey(@RequestParam("key") String key,
                            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                            Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        Page<HoaDon> hoaDonPage = PageUtil.createPage(hoaDonService.findByKey(key), page, pageSize);
        model.addAttribute("orders", hoaDonPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", hoaDonPage.getTotalPages());
        return "/orders-table.jsp";
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

    @PostMapping("/orders/create")
    public String createOrder(@Valid @ModelAttribute("hoaDon") HoaDon hoaDon,
                              BindingResult result,
                              Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }

        if (result.hasErrors()) {
            model.addAttribute("cart", gioHangService.findAll());
            return "/cart.jsp";
        }

        hoaDonService.create(hoaDon);

        return "redirect:/orders/table";
    }

    @GetMapping("/orders/update/{id}")
    public String showUpdateOrder(@PathVariable("id") Integer id,
                                  @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                  Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }

        if (Auth.getLoggedInNhanVien().getVaiTro() == false) {
            return "/403.jsp";
        }

        HoaDon hoaDon = hoaDonService.findById(id);
        model.addAttribute("hoaDon", hoaDon);
        model.addAttribute("orderDetails", hoaDonChiTietService.findAllHoaDonChiTietByHoaDon(id));

        return "/orders-update.jsp";
    }

    @PostMapping("/orders/update")
    public String updateOrder(@Valid @ModelAttribute("hoaDon") HoaDon hoaDon,
                              BindingResult result,
                              @RequestParam("id") Integer id) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }

        if (Auth.getLoggedInNhanVien().getVaiTro() == false) {
            return "/403.jsp";
        }

        if (result.hasErrors()) {
            return "/orders-update.jsp";
        }

        hoaDon.setId(id);
        hoaDonService.update(hoaDon);

        return "redirect:/orders/table";
    }

    @GetMapping("/orders/cancel")
    public String cancelOrder(@RequestParam("id") Integer id) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }

        if (Auth.getLoggedInNhanVien().getVaiTro() == false) {
            return "/403.jsp";
        }

        hoaDonService.cancel(id);

        return "redirect:/orders/table";
    }

}
