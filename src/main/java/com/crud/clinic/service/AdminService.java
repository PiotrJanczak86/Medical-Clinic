package com.crud.clinic.service;

import com.crud.clinic.controller.exceptions.AdminNotFoundException;
import com.crud.clinic.domain.Admin;
import com.crud.clinic.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository repository;

    public List<Admin> getAdmins(){return repository.findAll();}

    public Admin saveAdmin(Admin admin) {return repository.save(admin);}

    public void deleteAdmin(Long id) throws AdminNotFoundException {
        Admin toBeDeletedAdmin = repository.findById(id).orElseThrow(AdminNotFoundException::new);
        repository.delete(toBeDeletedAdmin);
    }
}
