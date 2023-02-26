package com.kruger.challenge.repository;

import com.kruger.challenge.enums.Status;
import com.kruger.challenge.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, UUID> {
    @Query("SELECT e " +
            "FROM Employee e " +
            "left JOIN e.employeeVaccines ev " +
            "WHERE (LOWER(e.document) like LOWER(CONCAT('%',:value,'%')) " +
            "OR LOWER(e.firstName) like LOWER(CONCAT('%',:value,'%')) " +
            "OR LOWER(e.lastName) like LOWER(CONCAT('%',:value,'%'))) " +
            "AND e.status in :status ")
    List<Employee> findByFilters(@Param("value") String value,
                                 @Param("status") Status[] status);

    @Query("SELECT e FROM Employee e LEFT JOIN e.employeeVaccines ev " +
            "WHERE ev.vaccinationDate BETWEEN :startDate AND :endDate")
    List<Employee> findEmployeesWithVaccinesBetweenDates(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);
    List<Employee> findByActiveTrue();

    List<Employee> findByStatusIn(Status[] status);

    Optional<Employee> findByDocument(String document);

    @Query("SELECT e " +
            "FROM Employee e " +
            "JOIN e.employeeVaccines ev " +
            "JOIN ev.vaccine v " +
            "WHERE v.id = :id")
    List<Employee> findEmployeesByVaccineId(UUID id);

}
