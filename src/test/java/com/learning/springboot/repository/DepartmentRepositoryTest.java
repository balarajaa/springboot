package com.learning.springboot.repository;

import com.learning.springboot.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Mech Engg")
                .departmentCode("ME-01")
                .departmentAddress("ME Building")
                .build();
        entityManager.persist(department);
    }

    @Test
    public void testFindById() {
        Department department = repository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Mech Engg");

    }
}