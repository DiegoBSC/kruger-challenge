package com.kruger.challenge.dto.employee;

import com.kruger.challenge.model.EmployeeVaccine;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface EmployeeVaccineMapper {
    EmployeeVaccineDto toDto(EmployeeVaccine model);

    EmployeeVaccine toModel(EmployeeVaccineDto dto);
}
