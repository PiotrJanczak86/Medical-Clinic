package com.crud.clinic.repository;

import com.crud.clinic.domain.Doctor;
import com.crud.clinic.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    @Override
    Doctor save(Doctor doctor);

    Doctor getDoctorByUser(User user);

    @Override
    List<Doctor> findAll();

    @Override
    void deleteById(Long id);
}
