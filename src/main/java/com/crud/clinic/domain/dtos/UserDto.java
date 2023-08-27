package com.crud.clinic.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDto {
    private String login;
    private String password;
    private String role;
}