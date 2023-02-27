package com.kruger.challenge.service.impl;

import com.kruger.challenge.TestData;
import com.kruger.challenge.dto.TokenDto;
import com.kruger.challenge.dto.employee.EmployeeDto;
import com.kruger.challenge.dto.user.UserDto;
import com.kruger.challenge.dto.user.UserMapper;
import com.kruger.challenge.enums.Status;
import com.kruger.challenge.model.Rol;
import com.kruger.challenge.model.User;
import com.kruger.challenge.repository.UserRepository;
import com.kruger.challenge.security.AuthCredential;
import com.kruger.challenge.service.RolService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RolService rolService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserMapper userMapper;

    @Test
    public void testCreateUserByEmployee() {

        Rol rol = new Rol();
        rol.setName("Employee");

        EmployeeDto employeeDto = TestData.getEmployeeDtoData();
        User user = TestData.getUserData(employeeDto);

        Mockito.when(rolService.findByName(Mockito.any())).thenReturn(rol);
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
        Mockito.when(userMapper.toDto(Mockito.any(User.class))).thenReturn(TestData.getUserDtoData(employeeDto));

        UserDto result = userService.createUserByEmployee(employeeDto);

        assertNotNull(result);
        assertEquals(user.getId(), result.getId());
        assertEquals(user.getDocument(), result.getDocument());
        assertEquals(user.getFirstName(), result.getFirstName());
        assertEquals(user.getLastName(), result.getLastName());
        assertEquals(user.getBirthDate(), result.getBirthDate());
        assertEquals(user.getEmail(), result.getEmail());
        assertEquals(user.getAddress(), result.getAddress());
        assertEquals(user.getPhone(), result.getPhone());
        assertEquals(user.getUsername(), result.getUsername());
        assertEquals(user.getActive(), result.getActive());
        assertEquals(user.getStatus(), result.getStatus());
    }

    @Test
    public void testLoginSuccess() {

        User user = TestData.getUserData(TestData.getEmployeeDtoData());
        AuthCredential presenter = new AuthCredential("johndoe", "password");

        Mockito.when(userRepository.findByUsername("johndoe")).thenReturn(Optional.of(user));
        Mockito.when(passwordEncoder.matches("password", user.getPassword())).thenReturn(true);

        ResponseEntity result = userService.login(presenter);

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        TokenDto tokenDto = (TokenDto) result.getBody();
        assertNotNull(tokenDto.getAccessToken());
    }

    @Test()
    public void testLoginFailure() {

        AuthCredential authCredential = new AuthCredential("johndoe", "password");
        Mockito.when(userRepository.findByUsername("johndoe")).thenReturn(Optional.empty());

        ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class,
                () -> userService.login(authCredential));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
        assertEquals("Credenciales incorrectas", exception.getReason());

    }



}