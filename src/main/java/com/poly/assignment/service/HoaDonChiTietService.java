package com.poly.assignment.service;

import com.poly.assignment.entity.*;
import com.poly.assignment.util.PageUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HoaDonChiTietService {

    List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();

    public HoaDonChiTietService() {
        listHoaDonChiTiet.add(new HoaDonChiTiet("1", new HoaDon("1", new NhanVien("4", "NV04", "Nguyen Thi D", "d12345", "123456", false, true), new KhachHang("1", "KH01", "Luu Thi Hai Yen", "0345674567", true), LocalDateTime.now(), true), new SanPhamChiTiet("1", "SPCT01", "Basic", new KichThuoc("1", "KT01", "S", true), new MauSac("1", "MS01", "Den", true), new SanPham("1", "SP01", "Ao so mi", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-den-5-c0028085-1e0a-4909-8a9a-254b104651d7.jpg?v=1690163848063", true), 20, 50.0, "https://bizweb.dktcdn.net/100/438/408/products/smm4073-tra-5.jpg?v=1690163848063", true), 2, 50.0, true));
        listHoaDonChiTiet.add(new HoaDonChiTiet("2", new HoaDon("2", new NhanVien("2", "NV02", "Nguyen Thi B", "b12345", "123456", false, true), new KhachHang("3", "KH03", "Do Thi Hong Khanh", "0987654321", true), LocalDateTime.now(), true), new SanPhamChiTiet("2", "SPCT02", "Ke soc", new KichThuoc("2", "KT02", "M", true), new MauSac("3", "MS03", "Do", true), new SanPham("3", "SP03", "Ao hoodie", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-tra-5.jpg?v=1690163848063", true), 10, 100.0, "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xnh-4-5f31f3af-196e-474f-80eb-ce0b4617d518.jpg?v=1690163848063", true), 1, 100.0, true));
        listHoaDonChiTiet.add(new HoaDonChiTiet("3", new HoaDon("3", new NhanVien("3", "NV03", "Nguyen Van C", "c12345", "123456", false, true), new KhachHang("2", "KH02", "Hoang Quang Linh", "0312341234", true), LocalDateTime.now(), true), new SanPhamChiTiet("3", "SPCT03", "Tay ngan", new KichThuoc("3", "KT03", "L", true), new MauSac("2", "MS02", "Trang", true), new SanPham("4", "SP04", "Ao polo", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xnh-4-5f31f3af-196e-474f-80eb-ce0b4617d518.jpg?v=1690163848063", true), 15, 150.0, "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xdm-4.jpg?v=1690163848063", true), 1, 150.0, true));
        listHoaDonChiTiet.add(new HoaDonChiTiet("4", new HoaDon("4", new NhanVien("1", "NV01", "Nguyen Van A", "a12345", "123456", false, true), new KhachHang("5", "KH05", "Luu Thi Hai Yen", "0956781234", true), LocalDateTime.now(), true), new SanPhamChiTiet("1", "SPCT01", "Basic", new KichThuoc("1", "KT01", "S", true), new MauSac("1", "MS01", "Den", true), new SanPham("1", "SP01", "Ao so mi", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-den-5-c0028085-1e0a-4909-8a9a-254b104651d7.jpg?v=1690163848063", true), 20, 50.0, "https://bizweb.dktcdn.net/100/438/408/products/smm4073-tra-5.jpg?v=1690163848063", true), 3, 50.0, true));
        listHoaDonChiTiet.add(new HoaDonChiTiet("5", new HoaDon("5", new NhanVien("5", "NV05", "Nguyen Van E", "e12345", "123456", false, true), new KhachHang("4", "KH04", "Luu Thi Hai Yen", "0323452345", true), LocalDateTime.now(), true), new SanPhamChiTiet("2", "SPCT02", "Ke soc", new KichThuoc("2", "KT02", "M", true), new MauSac("3", "MS03", "Do", true), new SanPham("3", "SP03", "Ao hoodie", "https://bizweb.dktcdn.net/100/438/408/products/smm4073-tra-5.jpg?v=1690163848063", true), 10, 100.0, "https://bizweb.dktcdn.net/100/438/408/products/smm4073-xnh-4-5f31f3af-196e-474f-80eb-ce0b4617d518.jpg?v=1690163848063", true), 2, 100.0, true));
    }

    public Page<HoaDonChiTiet> findAll(int page, int pageSize) {
        return PageUtil.createPage(listHoaDonChiTiet, page, pageSize);
    }

    public HoaDonChiTiet findById(String id) {
        for (HoaDonChiTiet hoaDonChiTiet: listHoaDonChiTiet) {
            if (hoaDonChiTiet.getId().equals(id)) {
                return hoaDonChiTiet;
            }
        }

        return null;
    }

    public List<HoaDonChiTiet> findAllHoaDonChiTietByHoaDon(String id) {
        List<HoaDonChiTiet> result = new ArrayList<>();
        for (HoaDonChiTiet hoaDonChiTiet: listHoaDonChiTiet) {
            if (hoaDonChiTiet.getHoaDon().getId().equals(id)) {
                result.add(hoaDonChiTiet);
            }
        }

        return result;
    }

    public void create(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTiet.setId(UUID.randomUUID().toString());
        listHoaDonChiTiet.add(hoaDonChiTiet);
    }

    public void update(HoaDonChiTiet hoaDonChiTiet) {
        for (int i = 0; i < listHoaDonChiTiet.size(); i++) {
            if (listHoaDonChiTiet.get(i).getId().equals(hoaDonChiTiet.getId())) {
                listHoaDonChiTiet.set(i, hoaDonChiTiet);
            }
        }
    }

    public void cancel(String id) {
        for (HoaDonChiTiet hoaDonChiTiet: listHoaDonChiTiet) {
            if (hoaDonChiTiet.getId().equals(id)) {
                hoaDonChiTiet.setTrangThai(false);
            }
        }
    }

}
