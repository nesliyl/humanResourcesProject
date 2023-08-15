package com.example.humanresources.service.impl;

import com.example.humanresources.dto.DepartmentDto;
import com.example.humanresources.entity.Department;
import com.example.humanresources.exception.ResourceNotFoundException;
import com.example.humanresources.mapper.DepartmentMapper;
import com.example.humanresources.repository.DepartmentRepository;
import com.example.humanresources.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.maptoDepartment(departmentDto);
        Department savedepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department  is not exists with given id : " + departmentId));
        return DepartmentMapper.mapToDepartmentDto(department);


    }

    @Override
    public List<DepartmentDto> getAllDepartmants() {
        List<Department> departmants = departmentRepository.findAll();
        return departmants.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartments(Long departmentId, DepartmentDto departmentDto) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department is not exist with given id: " + departmentId));
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        department.setDepartmentSalary(departmentDto.getDepartmentSalary());
        Department updatedepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(updatedepartment);
    }

    @Override
    public void DeleteDepartment(Long departmentId) {

        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department is not exist with given id: " + departmentId));
        departmentRepository.deleteById(departmentId);

    }

    @Override
    public Long getDepartmentCount() {

        return departmentRepository.count();
    }
}
