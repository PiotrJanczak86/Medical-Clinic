package com.crud.clinic.repository;

import com.crud.clinic.domain.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {

    @Override
    Visit save(Visit visit);

    @Override
    Optional<Visit> findById(Long id);

    @Override
    List<Visit> findAll();

    @Override
    void deleteById(Long id);
}
