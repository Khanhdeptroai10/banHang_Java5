package com.poly.assignment.controller;

import com.poly.assignment.entity.Auth;
import com.poly.assignment.entity.NhanVien;
import com.poly.assignment.entity.SanPham;
import com.poly.assignment.service.AuthService;
import com.poly.assignment.service.GioHangService;
import com.poly.assignment.service.NhanVienService;
import com.poly.assignment.service.SanPhamService;
import com.poly.assignment.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class GeneralController {

    private final GioHangService gioHangService;

    private final SanPhamService sanPhamService;

    private final AuthService authService;

    @GetMapping("/login")
    public String login() {
        return "/login.jsp";
    }

    @PostMapping("/login")
    public String login(@RequestParam("tenDangNhap") String tenDangNhap,
                        @RequestParam("matKhau") String matKhau,
                        Model model) {
        NhanVien nhanVien = authService.login(tenDangNhap, matKhau);
        if (nhanVien != null) {
            Auth.setLoggedIn(true);
            Auth.setLoggedInNhanVien(nhanVien);
            model.addAttribute("nhanVien", nhanVien);
            return "redirect:/";
        } else {
            model.addAttribute("error", "Username or password is incorrect");
            return "/login.jsp";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        Auth.logout();
        return "redirect:/login";
    }

    @GetMapping
    public String index(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                        @RequestParam(value = "pageSize", required = false, defaultValue = "8") Integer pageSize,
                        Model model) {
        if (Auth.isLoggedIn() == false || Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        Page<SanPham> sanPhamPage = PageUtil.createPage(sanPhamService.findAll(), page, pageSize);
        model.addAttribute("products", sanPhamPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", sanPhamPage.getTotalPages());
        model.addAttribute("cart", gioHangService.findAll());
        model.addAttribute("nhanVien", Auth.getLoggedInNhanVien());
        return "/index.jsp";
    }

}
