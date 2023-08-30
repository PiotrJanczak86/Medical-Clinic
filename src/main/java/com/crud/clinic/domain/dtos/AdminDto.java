package com.crud.clinic.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AdminDto {
    private String name;
    private String lastname;
    private Long userId;
    private String logs;
}