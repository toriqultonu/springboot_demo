package com.koshailimited.springbootdemoproject.controller;

import com.koshailimited.springbootdemoproject.entity.Department;
import com.koshailimited.springbootdemoproject.error.DepartmentNotFoundException;
import com.koshailimited.springbootdemoproject.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder().departmentAddress("RUET").departmentCode("03").departmentId(1L).departmentName("CSE")
                    .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder().departmentAddress("RUET").departmentCode("02").departmentName("CSE")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
        mockMvc.perform(post("/departments").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\":\"CSE\",\n" +
                        "    \"departmentAddress\":\"RUET\",\n" +
                        "    \"departmentCode\":\"03\"\n" +
                        "}")).andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {

        Long departmentId = 1L;

        Mockito.when(departmentService.getDepartmentById(departmentId)).thenReturn(department);
        mockMvc.perform(get("/getdepartment/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}