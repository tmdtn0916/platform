package com.mnu.platform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long reviewId;

    @Column
    private String Content;


}
