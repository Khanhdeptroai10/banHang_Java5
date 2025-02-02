package com.poly.assignment.controller;

import com.poly.assignment.entity.Auth;
import com.poly.assignment.entity.KichThuoc;
import com.poly.assignment.service.KichThuocService;
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
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class KichThuocController {

    private final KichThuocService kichThuocService;

    @GetMapping("/products/sizes")
    public String pTable(@ModelAttribute("kichThuoc") KichThuoc kichThuoc,
                         @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                         Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        Page<KichThuoc> kichThuocPage = PageUtil.createPage(kichThuocService.findAll(), page, pageSize);
        model.addAttribute("sizes", kichThuocPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", kichThuocPage.getTotalPages());
        return "/sizes-table.jsp";
    }

    @GetMapping("/products/sizes/search")
    public String findByKey(@RequestParam("key") String key,
                            @ModelAttribute("kichThuoc") KichThuoc kichThuoc,
                            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                            Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        Page<KichThuoc> kichThuocPage = PageUtil.createPage(kichThuocService.findByKey(key), page, pageSize);
        model.addAttribute("sizes", kichThuocPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", kichThuocPage.getTotalPages());
        return "/sizes-table.jsp";
    }

    @ModelAttribute("status")
    public Map<Boolean, String> getStatus() {
        Map<Boolean, String> map = new LinkedHashMap<>();
        map.put(true, "Active");
        map.put(false, "Blocked");
        return map;
    }

    @PostMapping("/size/create")
    public String createSize(@Valid @ModelAttribute("kichThuoc") KichThuoc kichThuoc,
                             BindingResult result,
                             @RequestParam(value = "id", required = false) Integer id,
                             @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                             Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        if (result.hasErrors()) {
            Page<KichThuoc> kichThuocPage = PageUtil.createPage(kichThuocService.findAll(), page, pageSize);
            model.addAttribute("sizes", kichThuocPage.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("totalPages", kichThuocPage.getTotalPages());
            return "/sizes-table.jsp";
        }

        if (id != null && !id.toString().isBlank()) {
            kichThuoc.setId(id);
            kichThuocService.update(kichThuoc);
        } else {
            kichThuocService.create(kichThuoc);
        }

        return "redirect:/products/sizes";
    }

    @GetMapping("/size/update")
    public String updateSize(@RequestParam("id") Integer id,
                             @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                             Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        KichThuoc kichThuoc1 = kichThuocService.findById(id);
        model.addAttribute("kichThuoc", kichThuoc1);
        Page<KichThuoc> kichThuocPage = PageUtil.createPage(kichThuocService.findAll(), page, pageSize);
        model.addAttribute("sizes", kichThuocPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", kichThuocPage.getTotalPages());
        return "/sizes-table.jsp";
    }

    @GetMapping("/sizes/delete")
    public String deleteSize(@RequestParam("id") Integer id) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        kichThuocService.delete(id);
        return "redirect:/products/sizes";
    }

}
