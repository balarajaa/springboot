package com.learning.springboot.service;

import com.learning.springboot.entity.Department;
import com.learning.springboot.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getDepartmentList();

    Department getDepartmentById(Long id) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long id);

    Department updateDepartment(Long id, Department department);

    Department getDepartmentByName(String name);
}
