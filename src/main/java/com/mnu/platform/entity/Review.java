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
    private String title;

    @Column
    private boolean recommend;

    @Column
    private String Content;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private UserData user;

    @ManyToOne
    @JoinColumn(name = "game_no")
    private Game game;

}
