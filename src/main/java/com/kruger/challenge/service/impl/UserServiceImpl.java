package com.kruger.challenge.service.impl;

import com.kruger.challenge.dto.TokenDto;
import com.kruger.challenge.dto.employee.EmployeeDto;
import com.kruger.challenge.dto.user.UserDto;
import com.kruger.challenge.dto.user.UserMapper;
import com.kruger.challenge.model.Rol;
import com.kruger.challenge.model.User;
import com.kruger.challenge.repository.UserRepository;
import com.kruger.challenge.security.AuthCredential;
import com.kruger.challenge.security.TokenUtils;
import com.kruger.challenge.service.RolService;
import com.kruger.challenge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RolService rolService;

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUserByEmployee(EmployeeDto employeeDto) {

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.findByName("Employee"));

        User user = new User();
        user.setDocument(employeeDto.getDocument());
        user.setFirstName(employeeDto.getFirstName());
        user.setLastName(employeeDto.getLastName());
        user.setBirthDate(employeeDto.getBirthDate());
        user.setEmail(employeeDto.getEmail());
        user.setAddress(employeeDto.getAddress());
        user.setPhone(employeeDto.getPhone());
        user.setUsername(employeeDto.getDocument().toUpperCase().trim()+"."+ employeeDto.getFirstName().toUpperCase().trim());
        user.setPassword(new BCryptPasswordEncoder().encode(employeeDto.getDocument()));
        user.setRoles(roles);
        user.setActive(true);
        user.setStatus(employeeDto.getStatus());
        try {
            user = userRepository.save(user);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

        return userMapper.toDto(user);
    }

    @Override
    public UserDto addRoleToUser(UUID userId, UUID roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Not Found"));
        Rol role = rolService.findById(roleId);
        if (!user.getRoles().contains(role)) {
            user.getRoles().add(role);
            userRepository.save(user);
        }
        return userMapper.toDto(user);
    }

    @Override
    public UserDto deleteRoleToUser(UUID userId, UUID roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Not Found"));
        Rol role = rolService.findById(roleId);
        if (user.getRoles().contains(role)) {
            user.getRoles().remove(role);
            userRepository.save(user);
        }
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findByActive(true);
        return users.stream().map(userMapper::toDto).toList();
    }

    @Override
    public ResponseEntity<TokenDto> login(AuthCredential authCredential){
        Optional<User> user = userRepository
                .findByUsername(authCredential.getUsername());

        if(user.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Credenciales incorrectas");


        if(passwordEncoder.matches(authCredential.getPassword(), user.get().getPassword())){
            UserDto userDto = userMapper.toDto(user.get());
            return new ResponseEntity(new TokenDto(TokenUtils.generateToken(user.get().getUsername(), user.get().getEmail(), user.get().getRoles()), userDto), HttpStatus.OK);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Credenciales incorrectas");
        }
    }
}
