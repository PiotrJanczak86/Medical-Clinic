package com.crud.clinic.repository;

import com.crud.clinic.domain.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    @Override
    Doctor save(Doctor doctor);

    @Override
    Optional<Doctor> findById(Long id);

    @Override
    List<Doctor> findAll();

    @Override
    void deleteById(Long id);
}
