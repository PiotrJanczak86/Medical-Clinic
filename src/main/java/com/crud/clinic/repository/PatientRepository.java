package com.crud.clinic.repository;

import com.crud.clinic.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    @Override
    Patient save(Patient patient);

    @Override
    Optional<Patient> findById(Long id);

    @Override
    List<Patient> findAll();

    @Override
    void deleteById(Long id);
}