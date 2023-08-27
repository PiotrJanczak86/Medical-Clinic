package com.crud.clinic.domain.dtos;

import java.util.ArrayList;
import java.util.List;

public class PatientDto {
    private String name;
    private String lastname;
    private int pesel;
    private Long userId;
    private String mail;
    private List<Long> visitsIdList = new ArrayList<>();
}