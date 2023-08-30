package com.crud.clinic.mapper;

import com.crud.clinic.controller.exceptions.UserNotFoundException;
import com.crud.clinic.domain.Admin;
import com.crud.clinic.domain.User;
import com.crud.clinic.domain.dtos.AdminDto;
import com.crud.clinic.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminMapper {
    private final UserService userService;

    public AdminMapper(UserService userService) {
        this.userService = userService;
    }

    public Admin mapToAdmin(final AdminDto adminDto) throws UserNotFoundException {
        User user = userService.getUser(adminDto.getUserId());
        return new Admin(null, adminDto.getName(), adminDto.getLastname(), user, adminDto.getLogs());
    }

    public AdminDto mapToAdminDto(final Admin admin){
        return new AdminDto(admin.getName(), admin.getLastname(), admin.getUser().getId(), admin.getLogs());
    }

    public List<AdminDto> mapToAdminDtoList(final List<Admin> adminList){
        return adminList.stream()
                .map(this::mapToAdminDto)
                .toList();
    }
}