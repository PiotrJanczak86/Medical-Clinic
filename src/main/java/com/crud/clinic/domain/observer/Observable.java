package com.crud.clinic.domain.observer;

import com.crud.clinic.domain.Doctor;

public interface Observable {
    void registerObserver(Observer observer);
    void notifyObserversOnDoctorsLeave(Doctor doctor);
    void removeObserver(Observer observer);
}