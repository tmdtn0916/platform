package com.mnu.platform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
public class Subscribe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long subNo;

    @Column
    private String type;

    @Column
    private LocalDate startTime;

    @Column
    private LocalDate endDate;

    @OneToOne
    @JoinColumn(name = "user_no")
    private UserData user;
}
