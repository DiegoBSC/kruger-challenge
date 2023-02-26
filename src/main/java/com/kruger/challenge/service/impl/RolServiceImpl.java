package com.kruger.challenge.service.impl;

import com.kruger.challenge.dto.rol.RolDto;
import com.kruger.challenge.model.Rol;
import com.kruger.challenge.repository.RoleRepository;
import com.kruger.challenge.service.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RoleRepository roleRepository;

    @Override
    public Rol findByName(String name) {
        return roleRepository.findByName(name).orElse(null);
    }

    @Override
    public Rol findById(UUID id) {
        return roleRepository.findById(id).orElse(null);
    }
}
