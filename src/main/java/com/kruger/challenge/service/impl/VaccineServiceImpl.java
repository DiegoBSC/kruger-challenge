package com.kruger.challenge.service.impl;

import com.kruger.challenge.dto.vaccine.VaccineDto;
import com.kruger.challenge.dto.vaccine.VaccineMapper;
import com.kruger.challenge.model.Vaccine;
import com.kruger.challenge.repository.VaccineRepository;
import com.kruger.challenge.service.VaccineService;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.cfg.context.ConstraintDefinitionContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VaccineServiceImpl implements VaccineService {

    private final VaccineRepository vaccineRepository;

    private final VaccineMapper vaccineMapper;

    @Override
    public List<VaccineDto> getAllVaccine() {
        List<Vaccine> vaccines = (List<Vaccine>) vaccineRepository.findAll();
        return vaccines.stream().map(vaccineMapper::toDto).toList();
    }
}
