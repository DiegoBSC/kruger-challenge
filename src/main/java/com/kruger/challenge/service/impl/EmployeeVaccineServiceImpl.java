package com.kruger.challenge.service.impl;

import com.kruger.challenge.dto.employee.EmployeeVaccineDto;
import com.kruger.challenge.dto.employee.EmployeeVaccineMapper;
import com.kruger.challenge.dto.employee.EmployeeVaccineRequest;
import com.kruger.challenge.model.Employee;
import com.kruger.challenge.model.EmployeeVaccine;
import com.kruger.challenge.model.Vaccine;
import com.kruger.challenge.repository.EmployeeRepository;
import com.kruger.challenge.repository.EmployeeVaccineRepository;
import com.kruger.challenge.repository.VaccineRepository;
import com.kruger.challenge.service.EmployeeVaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeVaccineServiceImpl implements EmployeeVaccineService {

    private final EmployeeRepository employeeRepository;
    private final VaccineRepository vaccineRepository;
    private final EmployeeVaccineRepository employeeVaccineRepository;
    private final EmployeeVaccineMapper employeeVaccineMapper;

    @Override
    public EmployeeVaccineDto saveVaccineEmployee(EmployeeVaccineRequest employeeVaccineRequest) {

        Employee employee = employeeRepository.findById(employeeVaccineRequest.getEmployeeId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not Fount"));

        Vaccine vaccine = vaccineRepository.findById(employeeVaccineRequest.getVaccineId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaccine not Fount"));

        EmployeeVaccine employeeVaccine = EmployeeVaccine.builder()
                .vaccine(vaccine)
                .employee(employee)
                .vaccinationDate(employeeVaccineRequest.getVaccineDate().toInstant().atZone(ZoneId.systemDefault())
                .toLocalDateTime())
                .dose(employeeVaccineRequest.getDose())
                .build();

        return employeeVaccineMapper.toDto(employeeVaccineRepository.save(employeeVaccine));
    }
}
