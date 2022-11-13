package com.koshailimited.springbootdemoproject.service;

import com.koshailimited.springbootdemoproject.entity.Department;
import com.koshailimited.springbootdemoproject.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        Department department = Department.builder().
                                departmentId(1L).departmentAddress("RUET").departmentCode("03").departmentName("CSE")
                                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("CSE")).thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on valid department name")
    @Disabled
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "CSE";
        Department found = departmentService.getDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}