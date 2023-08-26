package com.crud.clinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping(value = "/new/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createUser() {
        return ResponseEntity.ok(new Object());
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<Object> getUser() {
        return ResponseEntity.ok(new Object());
    }


    @DeleteMapping (value = "/{userId}")
    public ResponseEntity<Object> deleteUser() {
        return ResponseEntity.ok(new Object());
    }


    @PutMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateUser() {
        return ResponseEntity.ok(new Object());
    }

}