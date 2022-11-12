package com.koshailimited.springbootdemoproject.controller;

import com.koshailimited.springbootdemoproject.entity.Department;
import com.koshailimited.springbootdemoproject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getdepartment/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/getdepartment/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("/getdepartment/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }
}
