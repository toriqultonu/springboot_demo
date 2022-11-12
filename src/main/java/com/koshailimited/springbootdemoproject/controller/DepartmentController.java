package com.koshailimited.springbootdemoproject.controller;

import com.koshailimited.springbootdemoproject.entity.Department;
import com.koshailimited.springbootdemoproject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){

         departmentService.saveDepartment(department);
         return department;
    }

    @GetMapping("/getalldepartment")
    public List<Department> fetchDepartmentList(){
        List<Department> departments = departmentService.getAllDepartment();
        return departments;
    }
}
