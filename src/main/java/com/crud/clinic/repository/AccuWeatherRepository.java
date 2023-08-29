package com.crud.clinic.repository;

import com.crud.clinic.domain.AllergiesData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccuWeatherRepository extends CrudRepository<AllergiesData, Long> {

    @Override
    AllergiesData save(AllergiesData allergiesData);

    AllergiesData findTopByOrderByIdDesc();
}