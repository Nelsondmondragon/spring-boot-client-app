package com.nedacort.spring.boot.backend.apirest.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class ClientDTO {
    private Integer id;
    private String firstName;
    private String secondName;
    private String surName;
    private String secondSurName;
    private LocalDateTime createAt;
}
