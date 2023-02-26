package com.kruger.challenge.controller;

import com.kruger.challenge.model.User;
import com.kruger.challenge.repository.UserRepository;
import com.kruger.challenge.security.AuthCredential;
import com.kruger.challenge.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @Operation(summary = "Endpoint para el respectivo login de usaurio", description = "Retorna token y usuario logueado")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthCredential authCredential) {
        return userService.login(authCredential);
    }

}
