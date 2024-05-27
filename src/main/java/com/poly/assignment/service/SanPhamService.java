package com.poly.assignment.service;

import com.poly.assignment.entity.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SanPhamService {

    List<SanPham> listSanPham = new ArrayList<>();

    @Autowired
    FileUploadService fileUploadService;

    public SanPhamService() {
        listSanPham.add(new SanPham("1", "SP01", "Ao so mi", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-den-5-c0028085-1e0a-4909-8a9a-254b104651d7.jpg?v=1690163848063", true));
        listSanPham.add(new SanPham("2", "SP02", "Ao khoac", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xdm-4.jpg?v=1690163848063", true));
        listSanPham.add(new SanPham("3", "SP03", "Ao hoodie", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-tra-5.jpg?v=1690163848063", true));
        listSanPham.add(new SanPham("4", "SP04", "Ao polo", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xnh-4-5f31f3af-196e-474f-80eb-ce0b4617d518.jpg?v=1690163848063", true));
        listSanPham.add(new SanPham("5", "SP05", "Ao ni", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-tit-5-71cfb015-53a4-4258-92ca-bc2e2be1bf5e.jpg?v=1690163848063", true));
        listSanPham.add(new SanPham("6", "SP06", "Ao phong", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-den-5-c0028085-1e0a-4909-8a9a-254b104651d7.jpg?v=1690163848063", true));
        listSanPham.add(new SanPham("7", "SP07", "Ao thun", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xdm-4.jpg?v=1690163848063", true));
        listSanPham.add(new SanPham("8", "SP08", "Ao vest", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-tra-5.jpg?v=1690163848063", false));
        listSanPham.add(new SanPham("9", "SP09", "Ao so mi tay dai", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xnh-4-5f31f3af-196e-474f-80eb-ce0b4617d518.jpg?v=1690163848063", true));
        listSanPham.add(new SanPham("10", "SP010", "Ao blazer", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-tit-5-71cfb015-53a4-4258-92ca-bc2e2be1bf5e.jpg?v=1690163848063", true));
    }

    public List<SanPham> findAll() {
        return listSanPham;
    }

    public SanPham findById(String id) {
        for (SanPham sanPham: listSanPham) {
            if (sanPham.getId().equals(id)) {
                return sanPham;
            }
        }

        return null;
    }

    public List<SanPham> findByKey(String key) {
        List<SanPham> result = new ArrayList<>();
        for (SanPham sanPham: listSanPham) {
            if (sanPham.getMaSP().toLowerCase().contains(key.toLowerCase()) || sanPham.getTen().toLowerCase().contains(key.toLowerCase())) {
                result.add(sanPham);
            }
        }

        return result;
    }

    public void create(SanPham sanPham, MultipartFile file) throws IOException {
        sanPham.setId(UUID.randomUUID().toString());
        sanPham.setHinhAnh(fileUploadService.uploadFile(file));
        listSanPham.add(sanPham);
    }

    public void update(SanPham sanPham, MultipartFile file) throws IOException {
        for (int i = 0; i < listSanPham.size(); i++) {
            if (listSanPham.get(i).getId().equals(sanPham.getId())) {
                sanPham.setHinhAnh(fileUploadService.uploadFile(file));
                listSanPham.set(i, sanPham);
            }
        }
    }

    public void delete(String id) {
        List<SanPham> deList = new ArrayList<>();
        for (int i = 0; i < listSanPham.size(); i++) {
            if (listSanPham.get(i).getId().equals(id)) {
                deList.add(listSanPham.get(i));
            }
        }

        listSanPham.removeAll(deList);
    }

}
