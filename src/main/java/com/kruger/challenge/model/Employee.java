package com.kruger.challenge.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kruger.challenge.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = "document")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "Cédula requerida")
    @Size(min=10, max=10, message = "Cédula invalida. El numero de cédula deberia tener al menos 10 digitos")
    @Pattern(regexp = "^[0-9]+$", message = "Cédula invalida. El numero de cédula debe incluir solo dígitos numéricos")
    @Column(unique = true)
    private String document;

    @NotNull(message = "Nombre Requerido")
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "El nombre NO debe contener dígitos numéricos ni caracteres especiales")
    private String firstName;

    @NotNull(message = "Apellido Requerido")
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "Los apellidos NO debe contener dígitos numéricos ni caracteres especiales")
    private String lastName;

    @Email(regexp = "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?",
            message = "Email Not Valid")
    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthDate;

    private String address;

    private String phone;

    private Boolean active = true;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<EmployeeVaccine> employeeVaccines = new HashSet<>();
}
