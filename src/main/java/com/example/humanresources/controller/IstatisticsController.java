package com.example.humanresources.controller;

import com.example.humanresources.dto.IstatisticsDto;
import com.example.humanresources.service.IstatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/istatistics")
public class IstatisticsController {

    @Autowired
    private IstatisticsService istatisticsService;


    public ResponseEntity<IstatisticsDto> getAllInfo()
    {
        IstatisticsDto istatisticsDto=istatisticsService.getAllInfo();
        return ResponseEntity.ok(istatisticsDto);
    }
}
