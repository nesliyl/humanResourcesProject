package com.example.humanresources.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Results {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date start_date;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch= FetchType.LAZY,
            optional = false

    )
    @JoinColumn(name = "worker_id")
    private Worker worker;



}
