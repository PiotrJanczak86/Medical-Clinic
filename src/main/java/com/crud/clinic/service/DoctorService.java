package com.crud.clinic.service;

import com.crud.clinic.controller.exceptions.DoctorNotFoundException;
import com.crud.clinic.domain.Doctor;
import com.crud.clinic.domain.observer.Observable;
import com.crud.clinic.domain.observer.Observer;
import com.crud.clinic.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService implements Observable {

    private final DoctorRepository repository;
    private final List<Observer> observers;

    public List<Doctor> getDoctors(){return repository.findAll();}

    public Doctor getDoctor(Long id) throws DoctorNotFoundException {
        return repository.findById(id).orElseThrow(DoctorNotFoundException::new);
    }

    public Doctor saveDoctor(Doctor doctor) {return repository.save(doctor);}

    public void deleteDoctor(Long id) throws DoctorNotFoundException{
        Doctor toBeDeletedDoctor = repository.findById(id).orElseThrow(DoctorNotFoundException::new);
        notifyObserversOnDoctorsLeave(toBeDeletedDoctor);
        repository.delete(toBeDeletedDoctor);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserversOnDoctorsLeave(Doctor doctor) {
        for (Observer observer : observers) {
            observer.updateOnDoctorsLeave(this, doctor);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}