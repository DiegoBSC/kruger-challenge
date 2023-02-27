package com.kruger.challenge.controller;

import com.kruger.challenge.dto.user.UserDto;
import com.kruger.challenge.service.UserService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/addRoleToUser")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserDto addRoleToUser (@RequestParam @NotNull @NotBlank UUID userId,
                                  @RequestParam @NotNull @NotBlank UUID roleId) {
        return userService.addRoleToUser(userId, roleId);
    }

    @GetMapping("/deleteRoleToUser")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserDto deleteRoleToUser (@RequestParam @NotNull @NotBlank UUID userId,
                                           @RequestParam @NotNull @NotBlank UUID roleId) {
        return userService.addRoleToUser(userId, roleId);
    }

    @GetMapping("/getAllUser")
    @PreAuthorize("Administrator")
    public List<UserDto> getAllUsers () {
        return userService.getUsers();
    }

}
