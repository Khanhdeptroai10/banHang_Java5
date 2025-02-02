package com.poly.assignment.controller;

import com.poly.assignment.entity.Auth;
import com.poly.assignment.entity.HoaDonChiTiet;
import com.poly.assignment.service.HoaDonChiTietService;
import com.poly.assignment.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HoaDonChiTietController {

    private final HoaDonChiTietService hoaDonChiTietService;

    @GetMapping("/order-details/table")
    public String getOrderDetails(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                  Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        Page<HoaDonChiTiet> hoaDonChiTietPage = PageUtil.createPage(hoaDonChiTietService.findAll(), page, pageSize);
        model.addAttribute("orderDetails", hoaDonChiTietPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", hoaDonChiTietPage.getTotalPages());
        return "/order-details-table.jsp";
    }

    @GetMapping("/order-details/table/search")
    public String findByKey(@RequestParam("key") Integer key,
                            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                            Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        Page<HoaDonChiTiet> hoaDonChiTietPage = PageUtil.createPage(hoaDonChiTietService.findByKey(key), page, pageSize);
        model.addAttribute("orderDetails", hoaDonChiTietPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", hoaDonChiTietPage.getTotalPages());
        return "/order-details-table.jsp";
    }

    @GetMapping("/order-details-by-order")
    public String getAllHoaDonChiTietByHoaDonId(@RequestParam("id") Integer id,
                                                @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                                Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        Page<HoaDonChiTiet> hoaDonChiTietPage = PageUtil.createPage(hoaDonChiTietService.findAllHoaDonChiTietByHoaDon(id), page, pageSize);
        model.addAttribute("orderDetails", hoaDonChiTietPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", hoaDonChiTietPage.getTotalPages());
        return "/order-details-table.jsp";
    }

}
