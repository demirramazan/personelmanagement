package com.rdemir.personelmanagment.rest;

import com.rdemir.personelmanagment.exception.ConfictExceptionHandler;
import com.rdemir.personelmanagment.model.Department;
import com.rdemir.personelmanagment.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("department")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    @PostMapping("/save")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
        Department department1 = departmentRepository.findByDepartmentName(department.getDepartmentName());
        if (department1 != null) {
            throw new ConfictExceptionHandler("Department is already saved.");
        }
        return new ResponseEntity<>(departmentRepository.save(department), HttpStatus.CREATED);
    }
}
