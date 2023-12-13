package com.mnu.platform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Table
@Getter
@Setter
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userNo;

    @Column(length = 50, unique = true, nullable = false)
    private String email;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 130, name = "password")
    private String passwd;

    @Column
    private LocalDate birth;

    @Column
    private String auth;

    @OneToMany(mappedBy = "user")
    private Set<Review> gameReviews;
}
