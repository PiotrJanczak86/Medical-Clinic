package com.crud.clinic.domain.observer;

import com.crud.clinic.domain.Doctor;
import com.crud.clinic.service.DoctorService;

public interface Observer {
    void updateOnDoctorsLeave(DoctorService doctorService, Doctor doctor);
}
