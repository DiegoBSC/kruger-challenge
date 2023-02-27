package com.kruger.challenge;

import com.kruger.challenge.dto.employee.EmployeeDto;
import com.kruger.challenge.dto.user.UserDto;
import com.kruger.challenge.enums.Status;
import com.kruger.challenge.model.Employee;
import com.kruger.challenge.model.User;

import java.time.LocalDateTime;

public final class TestData {
    public static EmployeeDto getEmployeeDtoData(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setDocument("123456789");
        employeeDto.setFirstName("John");
        employeeDto.setLastName("Doe");
        employeeDto.setBirthDate(LocalDateTime.now());
        employeeDto.setEmail("john.doe@example.com");
        employeeDto.setAddress("123 Main St");
        employeeDto.setPhone("555-555-1234");
        employeeDto.setStatus(Status.VACUNADO);
        return employeeDto;
    }

    public static User getUserData(EmployeeDto employeeDto){
        User user = new User();
        user.setDocument(employeeDto.getDocument());
        user.setFirstName(employeeDto.getFirstName());
        user.setLastName(employeeDto.getLastName());
        user.setBirthDate(employeeDto.getBirthDate());
        user.setEmail(employeeDto.getEmail());
        user.setAddress(employeeDto.getAddress());
        user.setPhone(employeeDto.getPhone());
        user.setUsername(employeeDto.getDocument().toUpperCase().trim()+"."+ employeeDto.getFirstName().toUpperCase().trim());
        user.setActive(true);
        user.setStatus(employeeDto.getStatus());
        return user;
    }
    public static UserDto getUserDtoData(EmployeeDto employeeDto){
        UserDto user = new UserDto();
        user.setDocument(employeeDto.getDocument());
        user.setFirstName(employeeDto.getFirstName());
        user.setLastName(employeeDto.getLastName());
        user.setBirthDate(employeeDto.getBirthDate());
        user.setEmail(employeeDto.getEmail());
        user.setAddress(employeeDto.getAddress());
        user.setPhone(employeeDto.getPhone());
        user.setUsername(employeeDto.getDocument().toUpperCase().trim()+"."+ employeeDto.getFirstName().toUpperCase().trim());
        user.setActive(true);
        user.setStatus(employeeDto.getStatus());
        return user;
    }
    public static Employee getEmployeeData(){
        Employee employee = new Employee();
        employee.setDocument("123456789");
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setBirthDate(LocalDateTime.now());
        employee.setEmail("john.doe@example.com");
        employee.setAddress("123 Main St");
        employee.setPhone("555-555-1234");
        employee.setStatus(Status.VACUNADO);
        return employee;
    }
}
