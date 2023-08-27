package com.crud.clinic.service;

import com.crud.clinic.controller.exceptions.DoctorNotFoundException;
import com.crud.clinic.domain.Doctor;
import com.crud.clinic.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository repository;

    public List<Doctor> getDoctors(){return repository.findAll();}

    public Doctor getDoctor(Long id) throws DoctorNotFoundException {
        return repository.findById(id).orElseThrow(DoctorNotFoundException::new);
    }

    public Doctor saveDoctor(Doctor doctor) {return repository.save(doctor);}

    public void deleteDoctor(Long id) throws DoctorNotFoundException{
        Doctor toBeDeletedDoctor = repository.findById(id).orElseThrow(DoctorNotFoundException::new);
        repository.delete(toBeDeletedDoctor);
    }
}