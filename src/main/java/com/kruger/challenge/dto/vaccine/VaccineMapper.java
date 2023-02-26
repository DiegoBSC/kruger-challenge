package com.kruger.challenge.dto.vaccine;

import com.kruger.challenge.model.Vaccine;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface VaccineMapper {

    VaccineDto toDto(Vaccine model);

    Vaccine toModel(VaccineDto dto);
}
