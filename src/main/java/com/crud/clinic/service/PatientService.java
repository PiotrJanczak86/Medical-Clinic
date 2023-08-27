package com.crud.clinic.service;

import com.crud.clinic.controller.exceptions.PatientNotFoundException;
import com.crud.clinic.domain.Patient;
import com.crud.clinic.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repository;

    public List<Patient> getPatients(){return repository.findAll();}

    public Patient getPatient(Long id) throws PatientNotFoundException {
        return repository.findById(id).orElseThrow(PatientNotFoundException::new);
    }

    public Patient savePatient(Patient patient) {return repository.save(patient);}

    public void deletePatient(Long id) throws PatientNotFoundException{
        Patient toBeDeletedPatient = repository.findById(id).orElseThrow(PatientNotFoundException::new);
        repository.delete(toBeDeletedPatient);
    }
}