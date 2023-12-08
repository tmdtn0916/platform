package com.mnu.platform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long categoryId;

    @Column(nullable = false, length = 50, unique = true)
    private String categoryName;

    // 추가적인 필드들도 필요한 경우에 추가 가능

    // 다대다 관계로 구현하기 위한 매핑
    @ManyToMany(mappedBy = "categories")
    private Set<Game> games;
}
