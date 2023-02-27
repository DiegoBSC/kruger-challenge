package com.kruger.challenge.security;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthCredential {
    private String username;
    private String password;
}
