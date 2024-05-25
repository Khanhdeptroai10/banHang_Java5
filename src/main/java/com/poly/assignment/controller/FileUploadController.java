package com.poly.assignment.controller;

import com.poly.assignment.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUploadService fileUploadService;

//    @PostMapping("/upload/edit")
//    public File handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
//        if (!file.isEmpty()) {
//            return fileUploadService.uploadFile(file);
//        }
//
//        return null;
////        return "redirect:/products/edit";
//    }

}
