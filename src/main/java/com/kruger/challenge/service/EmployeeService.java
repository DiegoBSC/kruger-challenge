package com.kruger.challenge.service;

import com.kruger.challenge.dto.employee.EmployeeDto;
import com.kruger.challenge.enums.Status;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(UUID employeeId, EmployeeDto employeeDto);

    List<EmployeeDto> findAll();

    EmployeeDto getEmployeeById(UUID employeeId) ;

    EmployeeDto getEmployeeByDocument(String document) ;

    String delete(UUID id);

    List<EmployeeDto> searchEmployees(String value, String status);

    List<EmployeeDto> getEmployeesByStatus(String status);

    List<EmployeeDto> getEmployeesByVaccineDate(Date initDate, Date endDate);

    Set<EmployeeDto> getEmployeesByVaccineId(UUID vaccineId);
}
