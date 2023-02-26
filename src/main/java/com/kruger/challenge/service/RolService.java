package com.kruger.challenge.service;

import com.kruger.challenge.dto.rol.RolDto;
import com.kruger.challenge.model.Rol;

import java.util.UUID;

public interface RolService {

    Rol findByName(String name);

    Rol findById(UUID id);
}
