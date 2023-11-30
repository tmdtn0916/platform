package com.mnu.platform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long producerNo;

    @Column(nullable = false, length = 50)
    private String company;

    @OneToMany(mappedBy = "producer")
    private List<Game> games;


}
