package com.kruger.challenge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString(of = "username")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class User extends Employee{
    private UUID id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    @Size(min=8, message = "La contraseña debe contener al menos 8 dígitos")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "rol_id")})
    private Set<Rol> roles = new HashSet<>();

}
