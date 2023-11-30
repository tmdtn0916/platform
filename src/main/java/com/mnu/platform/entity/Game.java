package com.mnu.platform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long gameNo;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 130)
    private String genre;

    @ManyToOne
    @JoinColumn(name = "producer_no")
    private Producer producer;

}
