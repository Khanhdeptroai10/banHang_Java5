package com.poly.assignment.controller;

import com.poly.assignment.entity.Auth;
import com.poly.assignment.entity.KhachHang;
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
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class KhachHangController {

    private final KhachHangService khachHangService;

    @GetMapping("/customers/table")
    public String pTable(@ModelAttribute("khachHang") KhachHang khachHang,
                         @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                         Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        Page<KhachHang> khachHangPage = PageUtil.createPage(khachHangService.findAll(), page, pageSize);
        model.addAttribute("customers", khachHangPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", khachHangPage.getTotalPages());
        return "/customers-table.jsp";
    }

    @GetMapping("/customer/{id}")
    public KhachHang getCustomerById(@PathVariable("id") Integer id) {
        return khachHangService.findById(id);
    }

    @GetMapping("/customer/search")
    public String findByKey(@RequestParam("key") String key,
                            @ModelAttribute("khachHang") KhachHang khachHang,
                            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                            Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        Page<KhachHang> khachHangPage = PageUtil.createPage(khachHangService.findByKey(key), page, pageSize);
        model.addAttribute("customers", khachHangPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", khachHangPage.getTotalPages());
        return "/customers-table.jsp";
    }

    @ModelAttribute("status")
    public Map<Boolean, String> getStatus() {
        Map<Boolean, String> map = new LinkedHashMap<>();
        map.put(true, "Active");
        map.put(false, "Blocked");
        return map;
    }

    @PostMapping("/customer/create")
    public String createCustomer(@Valid @ModelAttribute("khachHang") KhachHang khachHang,
                                 BindingResult result,
                                 @RequestParam(value = "id", required = false) Integer id,
                                 @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                 Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        if (result.hasErrors()) {
            Page<KhachHang> khachHangPage = PageUtil.createPage(khachHangService.findAll(), page, pageSize);
            model.addAttribute("customers", khachHangPage.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("totalPages", khachHangPage.getTotalPages());
            return "/customers-table.jsp";
        }

        if (id != null && !id.toString().isBlank()) {
            khachHang.setId(id);
            khachHangService.update(khachHang);
        } else {
            khachHangService.create(khachHang);
        }

        return "redirect:/customers/table";
    }

    @GetMapping("/customer/update")
    public String updateCustomer(@RequestParam("id") Integer id,
                                 @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                 Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        KhachHang khachHang1 = khachHangService.findById(id);
        model.addAttribute("khachHang", khachHang1);
        Page<KhachHang> khachHangPage = PageUtil.createPage(khachHangService.findAll(), page, pageSize);
        model.addAttribute("customers", khachHangPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", khachHangPage.getTotalPages());
        return "/customers-table.jsp";
    }

    @GetMapping("/customers/delete")
    public String deleteCustomer(@RequestParam("id") Integer id) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        khachHangService.delete(id);
        return "redirect:/customers/table";
    }

}
