package com.poly.assignment.entity;

public class Auth {

    private static boolean isLoggedIn = false;

    private static NhanVien loggedInNhanVien;

    public static boolean isLoggedIn() {
        return isLoggedIn;
    }

    public static void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public static NhanVien getLoggedInNhanVien() {
        return loggedInNhanVien;
    }

    public static void setLoggedInNhanVien(NhanVien nhanVien) {
        loggedInNhanVien = nhanVien;
    }

    public static void logout() {
        isLoggedIn = false;
        loggedInNhanVien = null;
    }

}
