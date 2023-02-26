package com.kruger.challenge.dto.user;

import com.kruger.challenge.dto.employee.EmployeeDto;
import com.kruger.challenge.dto.rol.RolDto;
import com.kruger.challenge.model.Employee;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends EmployeeDto {
    private UUID id;
    private String username;
    private String password;
    private List<RolDto> rolDto = new ArrayList<>();
}
