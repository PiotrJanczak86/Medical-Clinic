package com.crud.clinic.mapper;

import com.crud.clinic.domain.User;
import com.crud.clinic.domain.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMapper {

    public User mapToUser(final UserDto userDto){
        return new User(null, userDto.getLogin(), userDto.getPassword(), userDto.getRole());
    }

    public UserDto mapToUserDto(final User user){
        return new UserDto(user.getLogin(), user.getPassword(), user.getRole());
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList){
        return userList.stream()
                .map(this::mapToUserDto)
                .toList();
    }
}