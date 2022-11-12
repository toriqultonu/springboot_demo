package com.koshailimited.springbootdemoproject.service;

import com.koshailimited.springbootdemoproject.entity.Department;
import com.koshailimited.springbootdemoproject.error.DepartmentNotFoundException;
import com.koshailimited.springbootdemoproject.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }
    @Override
    public Department getDepartmentById(Long DepartmentId) throws DepartmentNotFoundException {
         Optional<Department> department = departmentRepository.findById(DepartmentId);

         if(!department.isPresent()){
             throw new DepartmentNotFoundException(("Department not available"));
         }
         return department.get();
    }

    @Override
    public void deleteDepartmentById(Long DepartmentId) {
        departmentRepository.deleteById(DepartmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department department1 = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())){
            department1.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            department1.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            department1.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(department1);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {

        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName );
    }


}
