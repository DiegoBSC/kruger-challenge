package com.kruger.challenge.service;

import com.kruger.challenge.dto.TokenDto;
import com.kruger.challenge.dto.employee.EmployeeDto;
import com.kruger.challenge.dto.user.UserDto;
import com.kruger.challenge.model.Employee;
import com.kruger.challenge.model.User;
import com.kruger.challenge.security.AuthCredential;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserDto createUserByEmployee(EmployeeDto employeeDto);

    UserDto addRoleToUser (UUID userId, UUID roleId);

    UserDto deleteRoleToUser (UUID userId, UUID roleId);

    List<UserDto> getUsers();

    ResponseEntity<TokenDto> login(AuthCredential presenter);
}
