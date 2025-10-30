package com.student.dao;

import java.sql.*;
import java.util.*;
import com.model.Student;
import com.student.util.DBConnect;

public class StudentDao {

    // Add new student
    public boolean addStudent(Student s) {
        String sql = "INSERT INTO students(name, course, email) VALUES(?,?,?)";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getCourse());
            ps.setString(3, s.getEmail());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all students
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setCourse(rs.getString("course"));
                s.setEmail(rs.getString("email"));
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Get student by ID
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id=?";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setCourse(rs.getString("course"));
                s.setEmail(rs.getString("email"));
                return s;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update student
    public boolean updateStudent(Student s) {
        String sql = "UPDATE students SET name=?, course=?, email=? WHERE id=?";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getCourse());
            ps.setString(3, s.getEmail());
            ps.setInt(4, s.getId());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete student
    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
