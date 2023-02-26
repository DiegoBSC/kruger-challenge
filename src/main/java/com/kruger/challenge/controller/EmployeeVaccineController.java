package com.kruger.challenge.controller;

import com.kruger.challenge.dto.employee.EmployeeVaccineDto;
import com.kruger.challenge.dto.employee.EmployeeVaccineRequest;
import com.kruger.challenge.service.EmployeeVaccineService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vaccine/employee")
@RequiredArgsConstructor
public class EmployeeVaccineController {

    private final EmployeeVaccineService employeeVaccineService;

    @PostMapping("/save")
    public EmployeeVaccineDto saveVaccineEmployee(@RequestBody @NotNull EmployeeVaccineRequest employeeVaccineRequest){
        return employeeVaccineService.saveVaccineEmployee(employeeVaccineRequest);
    }

}
