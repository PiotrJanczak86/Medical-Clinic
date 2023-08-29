package com.crud.clinic.repository;

import com.crud.clinic.domain.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {

    @Override
    Admin save(Admin admin);

    @Override
    List<Admin> findAll();

    @Override
    void deleteById(Long id);
}
