package com.learning.springboot.service;

import com.learning.springboot.entity.Department;
import com.learning.springboot.error.DepartmentNotFoundException;
import com.learning.springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository repository;

    @Override
    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public List<Department> getDepartmentList() {
        return repository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = repository.findById(id);

        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department Not Avaliable");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department departmentDB = repository.findById(id).get();

        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName())) {
            departmentDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            departmentDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            departmentDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return repository.save(departmentDB);

    }

    @Override
    public Department getDepartmentByName(String name) {
        return repository.findByDepartmentNameIgnoreCase(name);
    }
}
