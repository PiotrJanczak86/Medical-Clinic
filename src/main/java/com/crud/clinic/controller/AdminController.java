package com.crud.clinic.controller;

import com.crud.clinic.controller.exceptions.AdminNotFoundException;
import com.crud.clinic.controller.exceptions.UserNotFoundException;
import com.crud.clinic.domain.dtos.AdminDto;
import com.crud.clinic.mapper.AdminMapper;
import com.crud.clinic.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService;
    private final AdminMapper adminMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createAdmin(@RequestBody AdminDto adminDto) throws UserNotFoundException {
        adminService.saveAdmin(adminMapper.mapToAdmin(adminDto));
        return ResponseEntity.ok("ok");
    }

    @GetMapping
    public ResponseEntity<List<AdminDto>> getAdmins(){
        return ResponseEntity.ok(adminMapper.mapToAdminDtoList(adminService.getAdmins()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteAdmin(@PathVariable Long id) throws AdminNotFoundException{
        adminService.deleteAdmin(id);
        return ResponseEntity.ok("ok");
    }
}
