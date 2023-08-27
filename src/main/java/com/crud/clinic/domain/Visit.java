package com.crud.clinic.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="VISITS")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
    @NotNull
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID")
    @NotNull
    private Doctor doctor;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(targetEntity = CalendarEntry.class,
            mappedBy = "visit",
            fetch = FetchType.EAGER)
    private List<CalendarEntry> calendarEntriesList = new ArrayList<>();

    public static class VisitBuilder{
        private Patient patient;
        private Doctor doctor;
        private String description;
        private List<CalendarEntry> calendarEntriesList = new ArrayList<>();

        public VisitBuilder patient(Patient patient){
            this.patient = patient;
            return this;
        }
        public VisitBuilder doctor(Doctor doctor){
            this.doctor = doctor;
            return this;
        }
        public VisitBuilder description(String description){
            this.description = description;
            return this;
        }
        public VisitBuilder calendarEntry(CalendarEntry calendarEntry){
            calendarEntriesList.add(calendarEntry);
            return this;
        }
        public VisitBuilder calendarEntries(List<CalendarEntry> calendarEntries){
            calendarEntriesList.addAll(calendarEntries);
            return this;
        }
        public Visit build(){
            return new Visit(null, patient, doctor, description, calendarEntriesList);
        }
    }
}