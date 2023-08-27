package com.crud.clinic.mapper;

import com.crud.clinic.controller.exceptions.UserNotFoundException;
import com.crud.clinic.controller.exceptions.VisitNotFoundException;
import com.crud.clinic.domain.Patient;
import com.crud.clinic.domain.User;
import com.crud.clinic.domain.Visit;
import com.crud.clinic.domain.dtos.PatientDto;
import com.crud.clinic.service.UserService;
import com.crud.clinic.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientMapper {
    @Autowired
    private VisitService visitService;
    @Autowired
    private UserService userService;

    public PatientDto mapToPatientDto(final Patient patient) {
        List<Long> visitIds = patient.getVisitList().stream()
                .map(Visit::getId)
                .toList();
        return new PatientDto(patient.getName(), patient.getLastname(), patient.getPesel(), patient.getId(), patient.getMail(), visitIds);
    }

    public Patient mapToPatient(final PatientDto patientDto) throws UserNotFoundException {
        List<Visit> visits = patientDto.getVisitsIdList().stream()
                .map(v -> {
                    try {
                        return visitService.getVisit(v);
                    } catch (VisitNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }).toList();
        User user = userService.getUser(patientDto.getUserId());
        return new Patient(null, patientDto.getName(), patientDto.getLastname(), patientDto.getPesel(), user, patientDto.getMail(), visits);
    }

    public List<PatientDto> mapToPatientDtoList(final List<Patient> patientList) {
        return patientList.stream()
                .map(this::mapToPatientDto)
                .toList();
    }
}