package com.mnu.platform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "user_no")
    private UserData userData;

    @ManyToMany
    @JoinTable(
            name = "game_category",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;
}
