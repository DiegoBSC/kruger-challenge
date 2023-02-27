package com.kruger.challenge.service;

import com.kruger.challenge.dto.employee.EmployeeVaccineDto;
import com.kruger.challenge.dto.employee.EmployeeVaccineRequest;

import java.util.List;
import java.util.UUID;

public interface EmployeeVaccineService {
    EmployeeVaccineDto saveVaccineEmployee(EmployeeVaccineRequest employeeVaccineRequest);
    List<EmployeeVaccineDto> vaccineByEmployee(UUID employeeId);

}
