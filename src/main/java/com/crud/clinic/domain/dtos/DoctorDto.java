package com.crud.clinic.domain.dtos;

import java.util.ArrayList;
import java.util.List;

public class DoctorDto {
    private String name;
    private String lastname;
    private String specialization;
    private Long userId;
    private String mail;
    private List<Long> calendarEntriesList = new ArrayList<>();
    private List<Long> visitsIdList = new ArrayList<>();
}