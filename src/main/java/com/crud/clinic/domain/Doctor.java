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
@Entity(name="DOCTORS")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "LASTNAME")
    @NotNull
    private String lastname;

    @Column(name = "SPEC")
    @NotNull
    private String specialization;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "EMAIL")
    @NotNull
    private String mail;

    @OneToMany(targetEntity = Visit.class,
            mappedBy = "doctor",
            fetch = FetchType.EAGER)
    public List<Visit> visitList = new ArrayList<>();

    @OneToMany(targetEntity = CalendarEntry.class,
            mappedBy = "doctor",
            fetch = FetchType.EAGER)
    public List<CalendarEntry> calendarEntriesList = new ArrayList<>();
}