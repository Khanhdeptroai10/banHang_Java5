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
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
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

    @GetMapping("/nhan-vien/{id}")
    public NhanVien getEmployeeById(@PathVariable("id") String id) {
        return nhanVienService.findById(id);
    }

    @GetMapping("/nhan-vien/search")
    public List<NhanVien> findByKey(@RequestParam("key") String key) {
        return nhanVienService.findByKey(key);
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
                                 @RequestParam(value = "id", required = false) String id,
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

        if (!id.isBlank()) {
            nhanVien.setId(id);
            nhanVienService.update(nhanVien);
        } else {
            nhanVienService.create(nhanVien);
        }

        return "redirect:/employees/table";
    }

    @GetMapping("/employee/update")
    public String updateCustomer(@RequestParam("id") String id,
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
    public String deleteCustomer(@RequestParam("id") String id) {
        if (Auth.getLoggedInNhanVien() == null) {
            return "redirect:/login";
        }
        nhanVienService.delete(id);
        return "redirect:/employees/table";
    }

}
