package com.poly.assignment.entity;

public class Auth {

    private static NhanVien loggedInNhanVien;

    public static NhanVien getLoggedInNhanVien() {
        return loggedInNhanVien;
    }

    public static void setLoggedInNhanVien(NhanVien nhanVien) {
        loggedInNhanVien = nhanVien;
    }

    public static void logout() {
        loggedInNhanVien = null;
    }

}
