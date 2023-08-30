package com.crud.clinic.domain;

import com.crud.clinic.domain.observer.Observer;
import com.crud.clinic.service.DoctorService;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="ADMINS")
public class Admin implements Observer {
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

    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "LOGS")
    private String logs;

    @Override
    public void updateOnDoctorsLeave(DoctorService doctorService, Doctor doctor){
        logs = logs + "Doctor " + doctor.getName() + " " + doctor.getLastname() + "just deleted his account! \n";
    }
}