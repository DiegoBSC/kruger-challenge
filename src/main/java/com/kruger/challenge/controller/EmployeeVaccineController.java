package com.kruger.challenge.controller;

import com.kruger.challenge.dto.employee.EmployeeVaccineDto;
import com.kruger.challenge.dto.employee.EmployeeVaccineRequest;
import com.kruger.challenge.service.EmployeeVaccineService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vaccine/employee")
@RequiredArgsConstructor
public class EmployeeVaccineController {

    private final EmployeeVaccineService employeeVaccineService;

    @Operation(summary = "Endpoint registrar la vacuna por empleado", description = "Retorna se realiza la relacion de empleado y su vacuna respectiva")
    @PostMapping("/save")
    @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
    public EmployeeVaccineDto saveVaccineEmployee(@RequestBody @NotNull EmployeeVaccineRequest employeeVaccineRequest){
        return employeeVaccineService.saveVaccineEmployee(employeeVaccineRequest);
    }
    @Operation(summary = "Endpoint para obtener la vacuna por empleado", description = "Retorna se realiza la relacion de empleado y su vacuna respectiva")
    @GetMapping("/vaccineByEmployee")
    @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
    public List<EmployeeVaccineDto> vaccinesByEmployee(@RequestParam @NotNull UUID employeeId){
        return employeeVaccineService.vaccineByEmployee(employeeId);
    }

}
