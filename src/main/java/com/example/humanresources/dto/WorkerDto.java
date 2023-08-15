package com.example.humanresources.dto;


import com.example.humanresources.entity.Results;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class WorkerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private Results results;




}
