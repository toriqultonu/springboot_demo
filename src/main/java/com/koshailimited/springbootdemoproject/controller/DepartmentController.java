package com.koshailimited.springbootdemoproject.controller;

import com.koshailimited.springbootdemoproject.entity.Department;
import com.koshailimited.springbootdemoproject.error.DepartmentNotFoundException;
import com.koshailimited.springbootdemoproject.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
         LOGGER.info("Inside saveDepartment of DepartmentController");
         departmentService.saveDepartment(department);
         return department;
    }

    @GetMapping("/getalldepartment")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        List<Department> departments = departmentService.getAllDepartment();
        return departments;
    }

    @GetMapping("/getdepartment/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside fetchDepartmentById of DepartmentController");
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/getdepartment/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        LOGGER.info("Inside deleteDepartmentById of DepartmentController");
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("/getdepartment/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        LOGGER.info("Inside updateDepartment of DepartmentController");
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("getdepartment/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("Inside getDepartmentByName of DepartmentController");
        return departmentService.getDepartmentByName(departmentName);
    }
}
