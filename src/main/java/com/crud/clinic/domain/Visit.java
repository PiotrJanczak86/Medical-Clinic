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
    @NotNull
    private String description;

    @OneToMany(targetEntity = CalendarEntry.class,
            mappedBy = "visit",
            fetch = FetchType.EAGER)
    public List<Visit> calendarEntriesList = new ArrayList<>();
}