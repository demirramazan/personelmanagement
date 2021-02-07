package com.rdemir.personelmanagment.service;

import com.rdemir.personelmanagment.exception.ConfictExceptionHandler;
import com.rdemir.personelmanagment.exception.NotFoundExceptionHandler;
import com.rdemir.personelmanagment.model.Department;
import com.rdemir.personelmanagment.model.Personnel;
import com.rdemir.personelmanagment.repository.DepartmentRepository;
import com.rdemir.personelmanagment.repository.PersonnelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final PersonnelRepository personnelRepository;

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

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public boolean deleteDepartment(Long id) {
        Personnel personnel = personnelRepository.findByDepartmentId(id);
        if (personnel != null) {
            throw new ConfictExceptionHandler("You cannot delete it because it is a staff member.");
        }
        departmentRepository.deleteById(id);
        return true;
    }

    public Department updateDepartment(Department department) {
        if (department.getId() == null) {
            throw new NotFoundExceptionHandler("Department Id is not found");
        }
        Department department1 = departmentRepository.getOne(department.getId());
        if (department1 == null) {
            throw new NotFoundExceptionHandler("Department  is not found");
        }
        return departmentRepository.save(department);
    }
}
