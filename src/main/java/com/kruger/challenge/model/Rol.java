package com.kruger.challenge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name ="roles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique=true)
    @NotNull
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @Builder.Default
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "rol_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> users = new HashSet<>();

    @Builder.Default
    private Boolean active = true;
}
