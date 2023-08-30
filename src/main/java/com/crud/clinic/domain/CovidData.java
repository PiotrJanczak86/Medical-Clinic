package com.crud.clinic.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="COVID")
public class CovidData {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE")
    @NotNull
    private LocalDate date;

    @Column(name = "DEATHS")
    @NotNull
    private Long deaths;

    @Column(name = "NEW CASES")
    @NotNull
    private Long cases;

    @Column(name = "CRITICAL STATE")
    @NotNull
    private Long critical;
}
