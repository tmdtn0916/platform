package com.mnu.platform.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Data
@Setter
@Getter
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long platformId;

    @Column
    private String info;

    @Column
    private String name;

}
