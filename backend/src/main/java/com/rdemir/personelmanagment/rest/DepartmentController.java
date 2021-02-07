package com.rdemir.personelmanagment.rest;

import com.rdemir.personelmanagment.exception.ConfictExceptionHandler;
import com.rdemir.personelmanagment.model.Department;
import com.rdemir.personelmanagment.repository.DepartmentRepository;
import com.rdemir.personelmanagment.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department")
@AllArgsConstructor
@Api(value = "Department Api documentation")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;
    private final DepartmentService departmentService;

    @GetMapping("/all")
    @ApiOperation(value = "Get All Department")
    public ResponseEntity<List<Department>> getAllDepartment() {
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    @ApiOperation(value = "Get One Department")
    public ResponseEntity<Department> getDepartment(@PathVariable Long id) {
        return new ResponseEntity<>(departmentService.getDepartmentById(id), HttpStatus.OK);
    }

    @GetMapping("/find/{departmentName}")
    @ApiOperation(value = "Get One Department By Department Name")
    public ResponseEntity<Department> getDepartmentByName(@PathVariable String departmentName) {
        return new ResponseEntity<>(departmentService.getDepartmentByDepartmentName(departmentName), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value = " Departmanet Save Method")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
        Department department1 = departmentService.getDepartmentByDepartmentName(department.getDepartmentName());
        if (department1 != null) {
            throw new ConfictExceptionHandler("Department is already saved.");
        }
        return new ResponseEntity<>(departmentRepository.save(department), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Departmanet Update Method")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.updateDepartment(department));
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Departmanet Delete Method By Department Id")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.deleteDepartment(id));
    }
}
