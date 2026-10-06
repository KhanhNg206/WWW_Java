package org.example.www_tuan06_bai05;

import org.example.www_tuan06_bai05.dao.DepartmentDAO;
import org.example.www_tuan06_bai05.model.Department;

import java.util.List;


public class TestDB {

    public static void main(String[] args) {
        DepartmentDAO departmentDAO = new DepartmentDAO();

        List<Department> listDepartment = departmentDAO.getAll();

        for(Department department : listDepartment){
            System.out.println(
                    "ID: " + department.getId()
                            + " | Name: " + department.getName()
            );
        }
    }
}
