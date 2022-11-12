package com.koshailimited.springbootdemoproject.service;

import com.koshailimited.springbootdemoproject.entity.Department;
import com.koshailimited.springbootdemoproject.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);
    public List<Department> getAllDepartment();
    public Department getDepartmentById(Long DepartmentId) throws DepartmentNotFoundException;
    public void deleteDepartmentById(Long DepartmentId);
    public Department updateDepartment(Long departmentId, Department department);
    public Department getDepartmentByName(String departmentName);

}
