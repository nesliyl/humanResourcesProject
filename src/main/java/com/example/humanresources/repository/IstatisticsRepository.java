package com.example.humanresources.repository;

import com.example.humanresources.dto.CountDto;
import com.example.humanresources.dto.IstatisticsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IstatisticsRepository extends JpaRepository<IstatisticsDto,Long> {

    @Query("SELECT " +
            "(SELECT COUNT(d) FROM Department d) AS department_num, " +
            "(SELECT COUNT(w) FROM Worker w) AS worker_num")
    IstatisticsDto getAllInfo();

}
