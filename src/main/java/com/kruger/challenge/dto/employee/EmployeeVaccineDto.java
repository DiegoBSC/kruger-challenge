package com.kruger.challenge.dto.employee;

import com.kruger.challenge.dto.employee.EmployeeDto;
import com.kruger.challenge.dto.vaccine.VaccineDto;
import com.kruger.challenge.model.Vaccine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeVaccineDto {
    private UUID id;
    private EmployeeDto employeeDto;
    private VaccineDto vaccineDto;
    private int dose;
    private String vaccinationDate;
    private Boolean active;
}
