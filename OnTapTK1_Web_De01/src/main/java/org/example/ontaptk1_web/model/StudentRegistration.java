package org.example.ontaptk1_web.model;

import java.util.List;

public class StudentRegistration {
    private String fullName;
    private String email;
    private String course;
    private List<String> skills;
    private String mode;

    public StudentRegistration() {
    }

    public StudentRegistration(String fullName, String email, String course, List<String> skills, String mode) {
        this.fullName = fullName;
        this.email = email;
        this.course = course;
        this.skills = skills;
        this.mode = mode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}

