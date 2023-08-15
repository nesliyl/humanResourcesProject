package com.example.humanresources.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="workers")
@Data

public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column (name="last_name")
    private String lastName;
    @Column (name="e-mail")
    private String email;
    @Column (name="gender")
    private String gender;

    @OneToOne (
            cascade = CascadeType.ALL,
            mappedBy = "worker"
    )
    @JoinColumn(name="worker_id")
    private Results results;



}
