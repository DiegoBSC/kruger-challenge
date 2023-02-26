package com.kruger.challenge.dto.employee;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kruger.challenge.enums.Status;
import com.kruger.challenge.model.EmployeeVaccine;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto implements Comparable<EmployeeDto> {
    private UUID id;

    @NotNull(message = "Nombre Requerido")
    @NotBlank(message = "Nombre no puede estar vacio")
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "El nombre NO debe contener dígitos numéricos ni caracteres especialess")
    private String firstName;
    @NotNull(message = "Los Apellidos son qequeridos")
    @NotBlank(message = "Los Apellidos no pueden estar vacio")
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "Los Apellidos NO debe contener dígitos numéricos ni caracteres especialess")
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthDate;

    @NotNull(message = "Cédula requerida")
    @Size(min=10, max=10, message = "Cédula invalida. El numero de cédula deberia tener al 10 digitos")
    @Pattern(regexp = "^[0-9]+$", message = "Cédula invalida. El numero de cédula debe incluir solo dígitos numéricos")
    @Column(unique = true)
    private String document;
    private String address;
    @Email(regexp = "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?",
            message = "Email Not Valid")
    private String email;
    private Status status;
    private String phone;
    private Boolean active;

    @Override
    public int compareTo(EmployeeDto other) {
        return this.getDocument().compareTo(other.getDocument());
    }
}
