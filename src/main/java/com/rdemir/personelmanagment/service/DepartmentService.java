package com.rdemir.personelmanagment.service;

import com.rdemir.personelmanagment.model.Department;
import com.rdemir.personelmanagment.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Department getDepartmentByDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    public Department getDepartmentById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        return department.orElse(null);
    }

    public Department saveDepartment(Department department) {
        Department department1 = getDepartmentByDepartmentName(department.getDepartmentName());
        if (department1 != null)
            return department1;

        return departmentRepository.save(department);
    }
}
