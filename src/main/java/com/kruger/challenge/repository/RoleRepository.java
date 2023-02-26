package com.kruger.challenge.repository;

import com.kruger.challenge.model.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends CrudRepository<Rol, UUID> {

    Optional<Rol> findByName(String name);

}
