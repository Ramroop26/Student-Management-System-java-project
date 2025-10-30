package com.student.dao;

import java.sql.*;
import com.model.User;
import com.student.util.DBConnect;

public class UserDao {

    public boolean register(User user) {
        boolean status = false;
        String checkQuery = "SELECT * FROM users WHERE email = ?";
        String insertQuery = "INSERT INTO users(name, email, password) VALUES (?, ?, ?)";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement psCheck = con.prepareStatement(checkQuery)) {

            psCheck.setString(1, user.getEmail());
            ResultSet rs = psCheck.executeQuery();

            if (rs.next()) {
                System.out.println("⚠️ Email already exists: " + user.getEmail());
                return false; // Email duplicate
            }

            try (PreparedStatement psInsert = con.prepareStatement(insertQuery)) {
                psInsert.setString(1, user.getName());
                psInsert.setString(2, user.getEmail());
                psInsert.setString(3, user.getPassword());

                int rows = psInsert.executeUpdate();
                status = (rows > 0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public User login(String email, String password) {
        User user = null;
        String sql = "SELECT * FROM users WHERE email=? AND password=?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
