package com.poly.assignment.controller;

import com.poly.assignment.entity.*;
import com.poly.assignment.service.*;
import com.poly.assignment.util.PageUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class SanPhamChiTietController {

    private final SanPhamChiTietService sanPhamChiTietService;

    private final SanPhamService sanPhamService;

    private final KichThuocService kichThuocService;

    private final MauSacService mauSacService;

    private final GioHangService gioHangService;

    @GetMapping("/product-details/table")
    public String pTable(@ModelAttribute("sanPhamChiTiet") SanPhamChiTiet sanPhamChiTiet,
                         @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "8") Integer pageSize,
                         Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        Page<SanPhamChiTiet> sanPhamChiTietPage = PageUtil.createPage(sanPhamChiTietService.findAll(), page, pageSize);
        model.addAttribute("productDetails", sanPhamChiTietPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", sanPhamChiTietPage.getTotalPages());
        return "/product-details-table.jsp";
    }

    @GetMapping("/product-{pid}/details")
    public String getAllProductDetailByProductId(@PathVariable("pid") String pid,
                                                 @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                                 @RequestParam(value = "pageSize", required = false, defaultValue = "8") Integer pageSize,
                                                 Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        model.addAttribute("pid", pid);
        Page<SanPhamChiTiet> sanPhamChiTietPage = PageUtil.createPage(sanPhamChiTietService.findAllSanPhamChiTietBySanPham(pid), page, pageSize);
        model.addAttribute("productDetails", sanPhamChiTietPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", sanPhamChiTietPage.getTotalPages());
        model.addAttribute("cart", gioHangService.findAll());
        return "/product-details.jsp";
    }

    @GetMapping("/product-{pid}/details/search")
    public String findByKey(@PathVariable("pid") String pid,
                            @RequestParam("key") String key,
                            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "8") Integer pageSize,
                            Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        Page<SanPhamChiTiet> sanPhamChiTietPage = PageUtil.createPage(sanPhamChiTietService.findByKey(key), page, pageSize);
        model.addAttribute("productDetails", sanPhamChiTietPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", sanPhamChiTietPage.getTotalPages());
        return "redirect:/product-" + pid + "/details";
    }

    @ModelAttribute("kichThuocList")
    public List<KichThuoc> getKichThuocList() {
        return kichThuocService.findAll();
    }

    @ModelAttribute("mauSacList")
    public List<MauSac> getMauSacList() {
        return mauSacService.findAll();
    }

    @ModelAttribute("sanPhamList")
    public List<SanPham> getSanPhamList() {
        return sanPhamService.findAll();
    }

    @ModelAttribute("status")
    public Map<Boolean, String> getStatus() {
        Map<Boolean, String> map = new LinkedHashMap<>();
        map.put(true, "Active");
        map.put(false, "Blocked");
        return map;
    }

    @PostMapping("/product-details/create")
    public String createProduct(@Valid @ModelAttribute("sanPhamChiTiet") SanPhamChiTiet sanPhamChiTiet,
                                BindingResult result,
                                @RequestParam(value = "id", required = false) String id,
                                @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        if (result.hasErrors()) {
            Page<SanPhamChiTiet> sanPhamChiTietPage = PageUtil.createPage(sanPhamChiTietService.findAll(), page, pageSize);
            model.addAttribute("productDetails", sanPhamChiTietPage.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("totalPages", sanPhamChiTietPage.getTotalPages());
            return "/product-details-table.jsp";
        }

        sanPhamChiTiet.setKichThuoc(kichThuocService.findById(sanPhamChiTiet.getKichThuoc().getId()));
        sanPhamChiTiet.setMauSac(mauSacService.findById(sanPhamChiTiet.getMauSac().getId()));
        sanPhamChiTiet.setSanPham(sanPhamService.findById(sanPhamChiTiet.getSanPham().getId()));

        if (id != null && !id.isBlank()) {
            sanPhamChiTiet.setId(id);
            sanPhamChiTietService.update(sanPhamChiTiet);
        } else {
            sanPhamChiTietService.create(sanPhamChiTiet);
        }

        return "redirect:/product-details/table";
    }

    @GetMapping("/product-details/update")
    public String updateProduct(@RequestParam("id") String id,
                                @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        SanPhamChiTiet sanPhamChiTiet1 = sanPhamChiTietService.findById(id);
        model.addAttribute("sanPhamChiTiet", sanPhamChiTiet1);
        Page<SanPhamChiTiet> sanPhamChiTietPage = PageUtil.createPage(sanPhamChiTietService.findAll(), page, pageSize);
        model.addAttribute("productDetails", sanPhamChiTietPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", sanPhamChiTietPage.getTotalPages());
        return "/product-details-table.jsp";
    }

    @GetMapping("/product-details/delete")
    public String deleteProduct(@RequestParam("id") String id) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        sanPhamChiTietService.delete(id);
        return "redirect:/product-details/table";
    }

}
