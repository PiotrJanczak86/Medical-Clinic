package com.crud.clinic.controller;

import com.crud.clinic.controller.exceptions.UserNotFoundException;
import com.crud.clinic.domain.User;
import com.crud.clinic.domain.dtos.UserDto;
import com.crud.clinic.mapper.UserMapper;
import com.crud.clinic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userMapper.mapToUser(userDto));
        return ResponseEntity.ok("New user " + userDto.getLogin() + " was successfully created");
    }
    @GetMapping(value = "/check/{login}")
    public ResponseEntity<Boolean> checkIfUserExists(@PathVariable String login){
        return ResponseEntity.ok(userService.getUserByLogin(login).isPresent());
    }

    @GetMapping(value = "/{login}")
    public ResponseEntity<UserDto> getUser(@PathVariable String login){
        return ResponseEntity.ok(userMapper.mapToUserDto((userService.getUserByLogin(login).get())));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userMapper.mapToUserDtoList(userService.getUsers()));
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id)throws UserNotFoundException {
        String userName = userService.getUser(id).getLogin();
        userService.deleteUser(id);
        return ResponseEntity.ok("User " + userName + " was successfully deleted");
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        user.setId(id);
        userService.saveUser(user);
        return ResponseEntity.ok(userDto);
    }
}