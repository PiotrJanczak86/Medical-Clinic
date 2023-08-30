package com.crud.clinic.repository;

import com.crud.clinic.domain.CalendarEntry;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CalendarEntryRepository extends CrudRepository<CalendarEntry, Long> {

    @Override
    CalendarEntry save(CalendarEntry entry);

    @Override
    Optional<CalendarEntry> findById(Long id);

    @Override
    List<CalendarEntry> findAll();

    @Override
    void deleteById(Long id);

    List<CalendarEntry> findAllByDoctor_Id(Long id);

    List<CalendarEntry> findCalendarEntriesByDate(LocalDate localDate);
}