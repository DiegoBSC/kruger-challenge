package com.kruger.challenge.service;

import com.kruger.challenge.dto.employee.EmployeeVaccineDto;
import com.kruger.challenge.dto.employee.EmployeeVaccineRequest;

public interface EmployeeVaccineService {
    EmployeeVaccineDto saveVaccineEmployee(EmployeeVaccineRequest employeeVaccineRequest);
}
