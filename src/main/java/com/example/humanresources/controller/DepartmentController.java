package com.example.humanresources.controller;


import com.example.humanresources.dto.DepartmentDto;
import com.example.humanresources.entity.Department;
import com.example.humanresources.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto)
    {
        DepartmentDto newDepartmentDto=departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(newDepartmentDto,HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentByID(@PathVariable("id") Long departmentId)
    {
                    DepartmentDto departmentDto=departmentService.getDepartmentById(departmentId);
                    return ResponseEntity.ok(departmentDto);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments()
    {
        List<DepartmentDto> departmentDtos = departmentService.getAllDepartmants();
        return ResponseEntity.ok(departmentDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartments(@PathVariable("id") Long departmentID,@RequestBody DepartmentDto departmentDto)
    {
        DepartmentDto updateDepartment= departmentService.updateDepartments(departmentID,departmentDto);
        return ResponseEntity.ok(updateDepartment);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId)
    {
        departmentService.DeleteDepartment(departmentId);
        return ResponseEntity.ok("Deleted department");
    }

}
