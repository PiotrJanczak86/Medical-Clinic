package com.crud.clinic.repository;

import com.crud.clinic.domain.CovidData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovidRepository extends CrudRepository<CovidData, Long> {

    @Override
    CovidData save(CovidData covidData);

    CovidData findTopByOrderByIdDesc();
}
