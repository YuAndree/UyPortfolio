package com.uy.portfolio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MessageFormDto {
    @NotBlank
    public String name;

    @Email
    @NotBlank
    public String email;

    @NotBlank
    public String message;
}
