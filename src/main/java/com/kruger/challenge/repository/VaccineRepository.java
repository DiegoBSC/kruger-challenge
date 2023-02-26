package com.kruger.challenge.repository;

import com.kruger.challenge.model.Vaccine;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VaccineRepository extends CrudRepository<Vaccine, UUID> {
}
