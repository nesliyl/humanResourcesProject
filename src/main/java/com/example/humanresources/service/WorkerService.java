package com.example.humanresources.service;


import com.example.humanresources.dto.WorkerDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkerService {

    WorkerDto createWorker(WorkerDto workerDto);
    WorkerDto getWorkerById(Long workerId);

    List<WorkerDto> getAllWorkers();

    WorkerDto updateWorker(Long workerid, WorkerDto updateWorker);

    void deleteWorker(Long workerid);

    Long getWorkerCount();



}
