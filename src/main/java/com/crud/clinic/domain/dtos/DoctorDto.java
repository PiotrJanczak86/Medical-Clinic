package com.crud.clinic.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class DoctorDto {
    private Long id;
    private String name;
    private String lastname;
    private String specialization;
    private Long userId;
    private String mail;
    private List<Long> calendarEntriesList;
    private List<Long> visitsIdList;
}