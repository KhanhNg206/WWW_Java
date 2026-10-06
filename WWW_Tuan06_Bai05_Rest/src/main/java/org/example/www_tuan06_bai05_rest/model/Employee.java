package org.example.www_tuan06_bai05_rest.model;


import java.math.BigDecimal;

public class Employee {

    private int id;
    private String name;
    private int departmentId;
    private BigDecimal salary;

    public Employee() {
    }

    public Employee(int id, String name, int departmentId, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
