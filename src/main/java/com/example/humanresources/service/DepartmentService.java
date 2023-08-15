package com.example.humanresources.service;

import com.example.humanresources.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(Long departmentId);

    List<DepartmentDto> getAllDepartmants();

    DepartmentDto updateDepartments(Long departmentId,DepartmentDto departmentDto);

    void DeleteDepartment(Long departmentId);

    Long getDepartmentCount();

}
