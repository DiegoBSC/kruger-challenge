package com.kruger.challenge.repository;

import com.kruger.challenge.model.EmployeeVaccine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeVaccineRepository extends CrudRepository<EmployeeVaccine, UUID> {

    Optional<List<EmployeeVaccine>> findByEmployeeId(UUID id);

}
