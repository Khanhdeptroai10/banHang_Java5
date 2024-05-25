package com.poly.assignment.controller;

import com.poly.assignment.entity.*;
import com.poly.assignment.service.*;
import com.poly.assignment.util.PageUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class SanPhamController {

    private final SanPhamService sanPhamService;

    private final SanPhamChiTietService sanPhamChiTietService;

    private final FileUploadService fileUploadService;

    private final GioHangService gioHangService;

    @GetMapping("/products/edit")
    public String pEdit(@RequestParam(value = "pid", required = false) String pid, Model model) {
        if (Auth.isLoggedIn() == false || Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        if (pid != null) {
            model.addAttribute("product", sanPhamService.findById(pid));
            return "/product-edit.jsp";
        }
        return "redirect:/";
    }

    @GetMapping("/products/table")
    public String pTable(@ModelAttribute("sanPham") SanPham sanPham,
                         @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
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
        return "/products-table.jsp";
    }

    @GetMapping("/products/search")
    public List<SanPham> findByKey(@RequestParam("key") String key) {
        return sanPhamService.findByKey(key);
    }

    @ModelAttribute("status")
    public Map<Boolean, String> getStatus() {
        Map<Boolean, String> map = new LinkedHashMap<>();
        map.put(true, "Active");
        map.put(false, "Blocked");
        return map;
    }

    @PostMapping("/products/create")
    public String createProduct(@Valid @ModelAttribute("sanPham") SanPham sanPham,
                                BindingResult result,
                                @RequestParam(value = "id", required = false) String id,
                                @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                Model model) {
        if (Auth.isLoggedIn() == false || Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        if (result.hasErrors()) {
            Page<SanPham> sanPhamPage = PageUtil.createPage(sanPhamService.findAll(), page, pageSize);
            model.addAttribute("products", sanPhamPage.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("totalPages", sanPhamPage.getTotalPages());
            return "/products-table.jsp";
        }

        if (id != null && !id.isBlank()) {
            sanPham.setId(id);
            sanPhamService.update(sanPham);
        } else {
            sanPhamService.create(sanPham);
        }

        return "redirect:/products/table";
    }

    @GetMapping("/products/update")
    public String updateProduct(@RequestParam("id") String id,
                                @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                Model model) {
        if (Auth.isLoggedIn() == false || Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        SanPham sanPham1 = sanPhamService.findById(id);
        model.addAttribute("sanPham", sanPham1);
        Page<SanPham> sanPhamPage = PageUtil.createPage(sanPhamService.findAll(), page, pageSize);
        model.addAttribute("products", sanPhamPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", sanPhamPage.getTotalPages());
        return "/products-table.jsp";
    }

    @GetMapping("/products/delete")
    public String deleteProduct(@RequestParam("id") String id) {
        if (Auth.isLoggedIn() == false || Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        sanPhamService.delete(id);

        sanPhamChiTietService.findAllSanPhamChiTietBySanPham(id).forEach(sanPhamChiTiet ->
            sanPhamChiTietService.delete(sanPhamChiTiet.getId())
        );

        return "redirect:/products/table";
    }

}
