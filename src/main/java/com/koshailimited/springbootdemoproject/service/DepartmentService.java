package com.koshailimited.springbootdemoproject.service;

import com.koshailimited.springbootdemoproject.entity.Department;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);
    public List<Department> getAllDepartment();
    public Department getDepartmentById(Long DepartmentId);
}
