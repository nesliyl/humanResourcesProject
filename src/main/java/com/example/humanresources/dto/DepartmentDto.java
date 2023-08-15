package com.example.humanresources.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class DepartmentDto {

    private Long id;
    private String departmentName;
    private String departmentDescription;
    private Long departmentSalary;
}
