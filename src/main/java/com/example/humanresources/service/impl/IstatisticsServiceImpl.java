package com.example.humanresources.service.impl;

import com.example.humanresources.dto.IstatisticsDto;
import com.example.humanresources.entity.Department;
import com.example.humanresources.entity.Worker;
import com.example.humanresources.repository.IstatisticsRepository;
import com.example.humanresources.service.DepartmentService;
import com.example.humanresources.service.IstatisticsService;
import com.example.humanresources.service.WorkerService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class IstatisticsServiceImpl implements IstatisticsService {

    @Autowired
    private WorkerService workerService;
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private IstatisticsRepository istatisticsRepository;


    @Override
    public IstatisticsDto getAllInfo() {


        return istatisticsRepository.getAllInfo();

    }
}
