package com.crud.clinic.mapper;

import com.crud.clinic.controller.exceptions.CalendarEntryNotFoundException;
import com.crud.clinic.controller.exceptions.UserNotFoundException;
import com.crud.clinic.controller.exceptions.VisitNotFoundException;
import com.crud.clinic.domain.CalendarEntry;
import com.crud.clinic.domain.Doctor;
import com.crud.clinic.domain.User;
import com.crud.clinic.domain.Visit;
import com.crud.clinic.domain.dtos.DoctorDto;
import com.crud.clinic.service.CalendarEntryService;
import com.crud.clinic.service.UserService;
import com.crud.clinic.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorMapper {
    @Autowired
    private VisitService visitService;
    @Autowired
    private UserService userService;

    @Autowired
    private CalendarEntryService calendarEntryService;

    public DoctorDto mapToDoctorDto(final Doctor doctor){
        List<Long> visitIds = doctor.getVisitList().stream()
                .map(Visit::getId)
                .toList();

        List<Long> entryIds = doctor.getCalendarEntriesList().stream()
                .map(CalendarEntry::getId)
                .toList();

        return new DoctorDto(doctor.getName(), doctor.getLastname(), doctor.getSpecialization(), doctor.getUser().getId(), doctor.getMail(), entryIds, visitIds);
    }

    public Doctor mapToDoctor(final DoctorDto doctorDto) throws UserNotFoundException {
        List<Visit> visits = doctorDto.getVisitsIdList().stream()
                .map(v -> {
                    try {
                        return visitService.getVisit(v);
                    } catch (VisitNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }).toList();

        List<CalendarEntry> entries = doctorDto.getCalendarEntriesList().stream()
                .map(c -> {
                    try {
                        return calendarEntryService.getEntry(c);
                    } catch (CalendarEntryNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }).toList();
        User user = userService.getUser(doctorDto.getUserId());
        return new Doctor(null, doctorDto.getName(), doctorDto.getLastname(), doctorDto.getSpecialization(), user, doctorDto.getMail(), visits, entries);
    }

    public List<DoctorDto> mapToDoctorDtoList(final List<Doctor> doctorList){
        return doctorList.stream()
                .map(this::mapToDoctorDto)
                .toList();
    }
}