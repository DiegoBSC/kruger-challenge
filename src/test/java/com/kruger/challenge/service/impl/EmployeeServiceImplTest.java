package com.kruger.challenge.service.impl;

import com.kruger.challenge.TestData;
import com.kruger.challenge.dto.employee.EmployeeDto;
import com.kruger.challenge.dto.employee.EmployeeMapper;
import com.kruger.challenge.dto.user.UserDto;
import com.kruger.challenge.dto.user.UserMapper;
import com.kruger.challenge.model.Employee;
import com.kruger.challenge.model.Rol;
import com.kruger.challenge.repository.EmployeeRepository;
import com.kruger.challenge.repository.UserRepository;
import com.kruger.challenge.service.RolService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private UserServiceImpl userService;
    @InjectMocks
    private EmployeeServiceImpl employeeService;
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private EmployeeMapper employeeMapper;

    @Test
    void saveEmployee() {
        Rol rol = new Rol();
        rol.setName("Employee");

        EmployeeDto employeeDto = TestData.getEmployeeDtoData();
        UserDto userDto = TestData.getUserDtoData(employeeDto);

        Mockito.when(userService.createUserByEmployee(Mockito.any(EmployeeDto.class)))
                .thenReturn(userDto);

        EmployeeDto result = employeeService.saveEmployee(employeeDto);

        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        assertEquals("john.doe@example.com", result.getEmail());

        Mockito.verify(userService, Mockito.times(1)).createUserByEmployee(employeeDto);
    }
}