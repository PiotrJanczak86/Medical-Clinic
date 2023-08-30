package com.crud.clinic.service;

import com.crud.clinic.controller.exceptions.VisitNotFoundException;
import com.crud.clinic.domain.CalendarEntry;
import com.crud.clinic.domain.Doctor;
import com.crud.clinic.domain.Patient;
import com.crud.clinic.domain.Visit;
import com.crud.clinic.repository.CalendarEntryRepository;
import com.crud.clinic.repository.DoctorRepository;
import com.crud.clinic.repository.UserRepository;
import com.crud.clinic.repository.VisitRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class VisitService {

    private final CalendarEntryRepository calendarEntryRepository;
    private final VisitRepository repository;
    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;


    public List<Visit> getVisits(){return repository.findAll();}

    public Visit getVisit(Long id) throws VisitNotFoundException {
        return repository.findById(id).orElseThrow(VisitNotFoundException::new);
    }

    public Visit saveVisit(Visit visit) {

        repository.save(visit);
        CalendarEntry calendarEntry = calendarEntryRepository.findById(visit.getCalendarEntriesList().get(0).getId()).get();
        calendarEntry.setVisit(visit);

        return repository.save(visit);}

    public void deleteVisit(Long id) throws VisitNotFoundException{
        Visit toBeDeletedVisit = repository.findById(id).orElseThrow(VisitNotFoundException::new);
        repository.delete(toBeDeletedVisit);
    }

    public List<Visit> findVisitsByUserId(Long userId){
        return repository.findVisitsByDoctor(doctorRepository.getDoctorByUser(userRepository.findById(userId).get()));
    }

    public void appointVisit(Patient patient, Doctor doctor, String description, List<CalendarEntry> entries){
        Visit visit = new Visit.VisitBuilder()
                .patient(patient)
                .doctor(doctor)
                .description(description)
                .calendarEntries(entries)
                .build();
        repository.save(visit);
    }
}