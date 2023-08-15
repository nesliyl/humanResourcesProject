package com.example.humanresources.mapper;

import com.example.humanresources.dto.WorkerDto;
import com.example.humanresources.entity.Worker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WorkerMapper {
    public static Worker mapToWorker(WorkerDto workerDto) {
        return new Worker(
                workerDto.getId(),
                workerDto.getFirstName(),
                workerDto.getLastName(),
                workerDto.getEmail(),
                workerDto.getGender(),
                workerDto.getResults()


        );
    }

    public static WorkerDto mapToWorkerDto(Worker worker) {
        return new WorkerDto(
                worker.getId(),
                worker.getFirstName(),
                worker.getLastName(),
                worker.getEmail(),
                worker.getGender(),
                worker.getResults()
        );
    }


}
