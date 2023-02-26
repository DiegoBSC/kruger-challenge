package com.kruger.challenge.service.impl;

import com.kruger.challenge.dto.employee.EmployeeDto;
import com.kruger.challenge.dto.employee.EmployeeMapper;
import com.kruger.challenge.enums.Status;
import com.kruger.challenge.model.Employee;
import com.kruger.challenge.repository.EmployeeRepository;
import com.kruger.challenge.service.EmployeeService;
import com.kruger.challenge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final UserService userService;

    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        return userService.createUserByEmployee(employeeDto);
    }

    @Override
    public EmployeeDto updateEmployee(UUID employeeId, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro el empleado"));

        employee.setBirthDate(employeeDto.getBirthDate());
        employee.setAddress(employeeDto.getAddress());
        employee.setPhone(employeeDto.getPhone());
        employee.setStatus(employeeDto.getStatus());
        employee.setBirthDate(employeeDto.getBirthDate());
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    @Override
    public List<EmployeeDto> findAll() {
        List<Employee> employees = employeeRepository.findByActiveTrue();
        return employees.stream().map(employeeMapper::toDto).toList();
    }

    @Override
    public EmployeeDto getEmployeeById(UUID employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro el empleado"));
        return employeeMapper.toDto(employee);
    }

    @Override
    public EmployeeDto getEmployeeByDocument(String document) {
        Employee employee = employeeRepository.findByDocument(document)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro el empleado"));
        return employeeMapper.toDto(employee);
    }

    @Override
    public String delete(UUID id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employee.get().setActive(false);
            employeeRepository.save(employee.get());
            return "deleted correctly";
        }
        return "employee not found";
    }

    @Override
    public List<EmployeeDto> searchEmployees(String value, String status) {
        Status[] vaccineStatus;
        try {
            vaccineStatus = status==null || status.isEmpty() ? Status.values() : new Status[]{Status.valueOf(status)};
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status Not Exist");
        }
        List<Employee> employees = employeeRepository.findByFilters(value, vaccineStatus);

        return employees.stream().map(employeeMapper::toDto).toList();
    }

    @Override
    public List<EmployeeDto> getEmployeesByStatus(String status) {
        Status[] vaccineStatus;
        try {
            vaccineStatus = status==null || status.isEmpty() ? Status.values() : new Status[]{Status.valueOf(status)};
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status Not Exist");
        }
        List<Employee> employees = employeeRepository.findByStatusIn(vaccineStatus);
        return employees.stream().map(employeeMapper::toDto).toList();
    }

    @Override
    public List<EmployeeDto> getEmployeesByVaccineDate(Date initDate, Date endDate) {
        List<Employee> employees = employeeRepository
                .findEmployeesWithVaccinesBetweenDates(initDate.toInstant().atZone(ZoneId.systemDefault())
                .toLocalDateTime(), endDate.toInstant().atZone(ZoneId.systemDefault())
                .toLocalDateTime());
        return employees.stream().map(employeeMapper::toDto).toList();
    }

    @Override
    public Set<EmployeeDto> getEmployeesByVaccineId(UUID vaccineId) {
        List<Employee> employees = employeeRepository.findEmployeesByVaccineId(vaccineId);
        return employees.stream().filter(Employee::getActive).map(employeeMapper::toDto).collect(Collectors.toSet());
    }

}
