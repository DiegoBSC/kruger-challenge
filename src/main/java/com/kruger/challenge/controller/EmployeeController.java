package com.kruger.challenge.controller;

import com.kruger.challenge.dto.employee.EmployeeDto;
import com.kruger.challenge.dto.employee.EmployeeMapper;
import com.kruger.challenge.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    private final EmployeeMapper employeeMapper;

    @Operation(summary = "Crea Empleadocon sus datos iniciales", description = "Retorna el empleado creado")
    @PostMapping("/app/saveEmployee")
    @PreAuthorize("Administrator")
    public EmployeeDto saveEmployee(@RequestBody @NotNull @Valid EmployeeDto employeeDto) {
            return employeeService.saveEmployee(employeeDto);
    }

    @Operation(summary = "Completa los datos del Empleado", description = "Retorna el empleado actualizado")
    @PutMapping("/app/updateEmployee")
    @PreAuthorize("Employee")
    public EmployeeDto updateEmployee(@RequestBody @NotNull @Valid EmployeeDto employeeDto,
                                      @RequestParam @NotNull UUID employeeId) {
        return employeeService.updateEmployee(employeeId, employeeDto);
    }

    @Operation(summary = "Retorna todos los Empleados registrados", description = "Retorna todos los Empleados registrados")
    @GetMapping("/app/findAllEmployees")
    @PreAuthorize("Administrator")
    public List<EmployeeDto> findAll() {
        return employeeService.findAll();
    }

    @Operation(summary = "Busca empleado por su cédula de identidad", description = "Retorna el empelado encontrado por su cédula de identidad")
    @GetMapping("/app/getEmployeeByDocument")
    @PreAuthorize("Administrator")
    public EmployeeDto getEmployeeByDocument(@RequestParam @NotNull String document)  {
        return employeeService.getEmployeeByDocument(document);
    }

    @Operation(summary = "Busca empleado por su id", description = "Retorna todos el empleado encontrado por id")
    @GetMapping("/app/getEmployeeById")
    @PreAuthorize("Administrator")
    public EmployeeDto getEmployeeById(@RequestParam @NotNull UUID employeeId)  {
        return employeeService.getEmployeeById(employeeId);
    }

    @Operation(summary = "Elimina empleado por su id", description = "Retorna resultdo de la operación si fue eliminado o no")
    @DeleteMapping("/app/deleteEmployee")
    @PreAuthorize("Administrator")
    public String deleteEmployee(@RequestParam @NotNull UUID employeeId) {
        return employeeService.delete(employeeId);
    }

    @Operation(summary = "Filtra los empleados segun su estado", description = "Retorna resultdo de los filtros VACUNA / NO_VACUNADO")
    @GetMapping("/app/findEmployeesByStatus")
    public List<EmployeeDto> getEmployeesByStatus(@RequestParam(value = "status") String status) {
        return employeeService.getEmployeesByStatus(status);
    }

    @Operation(summary = "Filtra los empleados segun la vacuna", description = "Retorna resultdo del filtro por vacuna")
    @GetMapping("/app/findEmployeesByVaccineId")
    public Set<EmployeeDto> getEmployeesByVaccineId(
            @RequestParam @NotNull UUID vaccineId)  {
        return employeeService.getEmployeesByVaccineId(vaccineId);
    }

    @Operation(summary = "Filtra los empleados por el rango de fechas de vacuna", description = "Retorna resultdo del filtro por fecha de vacuna")
    @GetMapping("/app/findEmployeesByVaccineDate")
    public List<EmployeeDto> getEmployeesByVaccineDate(
            @RequestParam(value = "initDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date initDate,
            @RequestParam(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate)  {
        return employeeService.getEmployeesByVaccineDate(initDate, endDate);
    }

    @Operation(summary = "Filtra los empleados por el un filtro", description = "Retorna resultdo del filtro por nombre, apellido o  cédula de identidad")
    @GetMapping("/app/searchEmployees")
    public List<EmployeeDto> searchEmployees(@RequestParam(value = "value", required = false) String value,
                                                   @RequestParam(value = "status", required = false) String status) {
        return employeeService.searchEmployees(value, status);
    }
}
