package com.nedacort.spring.boot.backend.apirest.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "surname")
    private String surName;
    @Column(name = "second_surname")
    private String secondSurName;
    @Column(name = "create_at")
    private LocalDateTime createAt;


}
