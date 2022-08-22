package com.learning.springboot.controller;

import com.learning.springboot.entity.Department;
import com.learning.springboot.error.DepartmentNotFoundException;
import com.learning.springboot.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartmentList() {
        LOGGER.info("Inside getDepartmentList of DepartmentController");
        return departmentService.getDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable Long id) throws DepartmentNotFoundException {
        LOGGER.info("Inside getDepartmentById of DepartmentController");
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable Long id) {
        LOGGER.info("Inside deleteDepartmentById of DepartmentController");
        departmentService.deleteDepartmentById(id);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        LOGGER.info("Inside updateDepartment of DepartmentController");
        return departmentService.updateDepartment(id,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable String name) {
        LOGGER.info("Inside getDepartmentByName of DepartmentController");
        return departmentService.getDepartmentByName(name);
    }
}
