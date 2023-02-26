package com.kruger.challenge.controller;

import com.kruger.challenge.dto.vaccine.VaccineDto;
import com.kruger.challenge.service.VaccineService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vaccine")
@RequiredArgsConstructor
public class VaccineController {

    private final VaccineService vaccineService;

    @Operation(summary = "Consulta todas las vacunas registradas", description = "Retorna lista de vacunas resgistradas en la bdd")
    @GetMapping("/all")
    public List<VaccineDto> getAllVaccine(){
        return vaccineService.getAllVaccine();
    }
}
