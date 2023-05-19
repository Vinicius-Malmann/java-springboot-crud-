package com.userRegistration.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto
{
    private int id;
    @NotEmpty
    private String name;
    @NotEmpty(message = "Email não pode estar vazio")
    @Email
    private String email;
    @NotEmpty(message = "Senha não pode estar vazio ")
    private String password;
    private int profile;
}
