package com.mnu.platform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @ManyToMany
    @JoinTable(
            name = "library", // 매핑 테이블 이름
            joinColumns = @JoinColumn(name = "user_no"),
            inverseJoinColumns = @JoinColumn(name = "game_no")
    )
    private Set<Game> games;
}
