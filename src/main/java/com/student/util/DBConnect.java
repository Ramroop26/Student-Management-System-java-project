package com.student.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    private static final String URL = "jdbc:mysql://localhost:3306/studentdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "1234";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ MySQL Driver Loaded Successfully!");
        } catch (Exception e) {
            System.err.println("❌ Error loading MySQL Driver:");
            e.printStackTrace();
        }
    }

    // ✅ This method will be used everywhere to get a database connection
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            System.err.println("❌ Database Connection Failed:");
            e.printStackTrace();
        }
        return con;
    }

    // For testing only
    public static void main(String[] args) {
        try (Connection con = DBConnect.getConnection()) {
            if (con != null) {
                System.out.println("✅ Database Connected Successfully!");
            } else {
                System.out.println("❌ Failed to connect to Database!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
