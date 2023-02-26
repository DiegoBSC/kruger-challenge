package com.kruger.challenge.controller;

import com.kruger.challenge.dto.employee.EmployeeVaccineDto;
import com.kruger.challenge.dto.employee.EmployeeVaccineRequest;
import com.kruger.challenge.service.EmployeeVaccineService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Endpoint registrar la vacuna por empleado", description = "Retorna se realiza la relacion de empleado y su vacuna respectiva")
    @PostMapping("/save")
    public EmployeeVaccineDto saveVaccineEmployee(@RequestBody @NotNull EmployeeVaccineRequest employeeVaccineRequest){
        return employeeVaccineService.saveVaccineEmployee(employeeVaccineRequest);
    }

}
