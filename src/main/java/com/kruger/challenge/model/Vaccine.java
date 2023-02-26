package com.kruger.challenge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name ="vaccines")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String name;

    private String description;

    @OneToMany(mappedBy = "vaccine", fetch = FetchType.LAZY)
    @Builder.Default
    private Set<EmployeeVaccine> employeeVaccines = new HashSet<>();

    @Builder.Default
    private Boolean active = true;
}
