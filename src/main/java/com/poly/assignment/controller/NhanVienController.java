package com.poly.assignment.controller;

import com.poly.assignment.entity.Auth;
import com.poly.assignment.entity.NhanVien;
import com.poly.assignment.service.NhanVienService;
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
public class NhanVienController {

    private final NhanVienService nhanVienService;

    @GetMapping("/employees/table")
    public String pTable(@ModelAttribute("nhanVien") NhanVien nhanVien,
                         @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                         Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        Page<NhanVien> nhanVienPage = PageUtil.createPage(nhanVienService.findAll(), page, pageSize);
        model.addAttribute("employees", nhanVienPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", nhanVienPage.getTotalPages());
        return "/employees-table.jsp";
    }

    @GetMapping("/employees/search")
    public String findByKey(@RequestParam("key") String key,
                            @ModelAttribute("nhanVien") NhanVien nhanVien,
                            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                            Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        Page<NhanVien> nhanVienPage = PageUtil.createPage(nhanVienService.findByKey(key), page, pageSize);
        model.addAttribute("employees", nhanVienPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", nhanVienPage.getTotalPages());
        return "/employees-table.jsp";
    }

    @ModelAttribute("role")
    public Map<Boolean, String> getRole() {
        Map<Boolean, String> map = new LinkedHashMap<>();
        map.put(true, "Admin");
        map.put(false, "Employee");
        return map;
    }

    @ModelAttribute("status")
    public Map<Boolean, String> getStatus() {
        Map<Boolean, String> map = new LinkedHashMap<>();
        map.put(true, "Active");
        map.put(false, "Blocked");
        return map;
    }

    @PostMapping("/employee/create")
    public String createCustomer(@Valid @ModelAttribute("nhanVien") NhanVien nhanVien,
                                 BindingResult result,
                                 @RequestParam(value = "id", required = false) Integer id,
                                 @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                 Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        if (result.hasErrors()) {
            Page<NhanVien> nhanVienPage = PageUtil.createPage(nhanVienService.findAll(), page, pageSize);
            model.addAttribute("employees", nhanVienPage.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("totalPages", nhanVienPage.getTotalPages());
            return "/employees-table.jsp";
        }

        if (id != null && !id.toString().isBlank()) {
            nhanVien.setId(id);
            nhanVienService.update(nhanVien);
        } else {
            nhanVienService.create(nhanVien);
        }

        return "redirect:/employees/table";
    }

    @GetMapping("/employee/update")
    public String updateCustomer(@RequestParam("id") Integer id,
                                 @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                 Model model) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        NhanVien nhanVien1 = nhanVienService.findById(id);
        model.addAttribute("nhanVien", nhanVien1);
        Page<NhanVien> nhanVienPage = PageUtil.createPage(nhanVienService.findAll(), page, pageSize);
        model.addAttribute("employees", nhanVienPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", nhanVienPage.getTotalPages());
        return "/employees-table.jsp";
    }

    @GetMapping("/employees/delete")
    public String deleteCustomer(@RequestParam("id") Integer id) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        nhanVienService.delete(id);
        return "redirect:/employees/table";
    }

}
