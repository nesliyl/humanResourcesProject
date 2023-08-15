package com.example.humanresources.service.impl;


import com.example.humanresources.dto.WorkerDto;
import com.example.humanresources.entity.Worker;
import com.example.humanresources.exception.ResourceNotFoundException;
import com.example.humanresources.mapper.WorkerMapper;
import com.example.humanresources.repository.WorkerRepository;
import com.example.humanresources.service.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class WorkerServiceImpl implements WorkerService {

    private WorkerRepository workerRepository;

    @Override
    public WorkerDto createWorker(WorkerDto workerDto) {
        Worker worker = WorkerMapper.mapToWorker(workerDto);
        Worker savedWorker = workerRepository.save(worker);
        return WorkerMapper.mapToWorkerDto(savedWorker);


    }

    @Override
    public WorkerDto getWorkerById(Long workerId) {
     Worker worker=   workerRepository.findById(workerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Worker is not exists with given id : " + workerId));

       return WorkerMapper.mapToWorkerDto(worker);
    }

    @Override
    public List<WorkerDto> getAllWorkers() {

        List<Worker> workers = workerRepository.findAll();
        return workers.stream().map((worker) -> WorkerMapper.mapToWorkerDto(worker))
                .collect(Collectors.toList());
    }

    @Override
    public WorkerDto updateWorker(Long workerid, WorkerDto updateWorker) {
        Worker worker=   workerRepository.findById(workerid)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Worker is not exists with given id : " + workerid));

        worker.setFirstName(updateWorker.getFirstName());
        worker.setLastName(updateWorker.getLastName());
        worker.setEmail(updateWorker.getEmail());
        worker.setGender(updateWorker.getGender());

       Worker updateWorkers= workerRepository.save(worker);

       return WorkerMapper.mapToWorkerDto(updateWorkers);
    }

    @Override
    public void deleteWorker(Long workerid) {
        Worker worker= workerRepository.findById(workerid)  .orElseThrow(() ->
                new ResourceNotFoundException("Worker is not exists with given id : " + workerid));;

                workerRepository.deleteById(workerid);
    }

    @Override
    public Long getWorkerCount() {
        return workerRepository.count();
    }
}
