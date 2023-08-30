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
@Entity(name="PATIENTS")
public class Patient {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "LASTNAME")
    @NotNull
    private String lastname;

    @Column(name = "PESEL")
    @NotNull
    private int pesel;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "EMAIL")
    @NotNull
    private String mail;

    @OneToMany(targetEntity = Visit.class,
            mappedBy = "patient",
            fetch = FetchType.EAGER)
    public List<Visit> visitList = new ArrayList<>();
}