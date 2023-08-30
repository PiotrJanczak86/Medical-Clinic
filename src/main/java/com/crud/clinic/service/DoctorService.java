package com.crud.clinic.service;

import com.crud.clinic.controller.exceptions.DoctorNotFoundException;
import com.crud.clinic.domain.Admin;
import com.crud.clinic.domain.Doctor;
import com.crud.clinic.domain.Visit;
import com.crud.clinic.domain.observer.Observable;
import com.crud.clinic.domain.observer.Observer;
import com.crud.clinic.repository.AdminRepository;
import com.crud.clinic.repository.DoctorRepository;
import com.crud.clinic.repository.UserRepository;
import com.crud.clinic.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService implements Observable {

    private final DoctorRepository repository;
    private final UserRepository userRepository;
    private final List<Observer> observers;
    private final AdminRepository adminRepository;


    public List<Doctor> getDoctors(){return repository.findAll();}

    public Doctor getDoctor(Long userId){
        return repository.getDoctorByUser(userRepository.findById(userId).get());
    }

    public Doctor getDoctorById(Long id){return repository.getDoctorById(id);}

    public Doctor saveDoctor(Doctor doctor) {
        List<Admin> admins = adminRepository.findAll();
        for(Admin admin: admins){
            registerObserver(admin);
        }
        return repository.save(doctor);}

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