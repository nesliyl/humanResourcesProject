package com.example.humanresources.mapper;

import com.example.humanresources.dto.DepartmentDto;
import com.example.humanresources.entity.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentMapper {


    public static DepartmentDto mapToDepartmentDto (Department department)
    {
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentSalary());

    }

    public static Department maptoDepartment(DepartmentDto departmentDto)
    {
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentSalary()
        );
    }
}
