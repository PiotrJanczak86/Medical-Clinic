package com.crud.clinic.service;

import com.crud.clinic.controller.exceptions.UserNotFoundException;
import com.crud.clinic.domain.User;
import com.crud.clinic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> getUsers(){return repository.findAll();}

    public User getUser(Long id) throws UserNotFoundException {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User saveUser(User user) {return repository.save(user);}

    public void deleteUser(Long id) throws UserNotFoundException{
        User toBeDeletedUser = repository.findById(id).orElseThrow(UserNotFoundException::new);
        repository.delete(toBeDeletedUser);
    }
    public Optional<User> getUserByLogin(String login){
        return repository.findUserByLogin(login);
    }
}