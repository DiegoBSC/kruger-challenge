package com.kruger.challenge.dto.employee;

import com.kruger.challenge.model.Employee;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface EmployeeMapper {
    EmployeeDto toDto(Employee model);

    Employee toModel(EmployeeDto dto);
}
