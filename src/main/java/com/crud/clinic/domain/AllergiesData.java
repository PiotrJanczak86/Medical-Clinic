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
@Entity(name = "ALLERGIES")
public class AllergiesData {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE")
    @NotNull
    private LocalDate date;

    @Column(name = "GRASS")
    @NotNull
    private String grass;

    @Column(name = "GRASS VALUE")
    @NotNull
    private Long grassValue;

    @Column(name = "MOLD")
    @NotNull
    private String mold;

    @Column(name = "MOLD VALUE")
    @NotNull
    private Long MoldValue;

    @Column(name = "RAGWEED")
    @NotNull
    private String ragweed;

    @Column(name = "RAGWEED VALUE")
    @NotNull
    private Long ragweedValue;

    @Column(name = "TREE")
    @NotNull
    private String tree;

    @Column(name = "TREE VALUE")
    @NotNull
    private Long treeValue;

}
