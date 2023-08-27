package com.crud.clinic.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class PatientDto {
    private String name;
    private String lastname;
    private int pesel;
    private Long userId;
    private String mail;
    private List<Long> visitsIdList = new ArrayList<>();
}