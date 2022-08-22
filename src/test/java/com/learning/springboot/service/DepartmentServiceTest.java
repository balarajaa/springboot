package com.learning.springboot.service;

import com.learning.springboot.entity.Department;
import com.learning.springboot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
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
    void setUp( ) {
        Department department = Department.builder().
                departmentName("IT")
                .departmentCode("IT-01")
                .departmentAddress("IT-Block")
                .departmentId(1L).build();
        Mockito.when(departmentService.getDepartmentByName("IT"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on Valid Department Name")
    //@Disabled
    public void testFetchByDepartmentByName() {
        String departmentName = "IT";
        Department found = departmentService.getDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());

    }
}