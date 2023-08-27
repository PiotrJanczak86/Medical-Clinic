package com.crud.clinic.service;

import com.crud.clinic.controller.exceptions.VisitNotFoundException;
import com.crud.clinic.domain.Visit;
import com.crud.clinic.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository repository;

    public List<Visit> getVisits(){return repository.findAll();}

    public Visit getVisit(Long id) throws VisitNotFoundException {
        return repository.findById(id).orElseThrow(VisitNotFoundException::new);
    }

    public Visit saveVisit(Visit visit) {return repository.save(visit);}

    public void deleteVisit(Long id) throws VisitNotFoundException{
        Visit toBeDeletedVisit = repository.findById(id).orElseThrow(VisitNotFoundException::new);
        repository.delete(toBeDeletedVisit);
    }
}