package com.crud.clinic.domain.dtos;

import java.util.ArrayList;
import java.util.List;

public class VisitDto {
    private Long patientId;
    private Long doctorId;
    private String description;
    private List<Long> entriesId = new ArrayList<>();

}