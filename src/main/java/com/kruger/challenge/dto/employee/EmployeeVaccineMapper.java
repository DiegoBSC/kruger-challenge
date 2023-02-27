package com.kruger.challenge.dto.employee;

import com.kruger.challenge.model.EmployeeVaccine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface EmployeeVaccineMapper {

    @Mapping(source = "vaccine", target = "vaccineDto")
    EmployeeVaccineDto toDto(EmployeeVaccine model);

    EmployeeVaccine toModel(EmployeeVaccineDto dto);

    List<EmployeeVaccineDto> toVaccineDtoList(List<EmployeeVaccine> vaccines);
}
