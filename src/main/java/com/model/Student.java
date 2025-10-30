package com.model;

public class Student {
    private int id;
    private String name;
    private String course;
    private String email;

    // Default constructor
    public Student() {}

    // Constructor without ID (used for adding new students)
    public Student(String name, String course, String email) {
        this.name = name;
        this.course = course;
        this.email = email;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
