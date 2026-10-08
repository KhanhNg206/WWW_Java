package com.se.demorestdb.model;

public class Employee {
    private int id;
    private String name;
    private int department_id;
    private double salary;

    public Employee(int id, String name, int department_id, double salary) {
        this.id = id;
        this.name = name;
        this.department_id = department_id;
        this.salary = salary;
    }

    public Employee() {
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

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department_id=" + department_id +
                ", salary=" + salary +
                '}';
    }
}
