package xyz.rodran.calidato.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RuleSetRequestDTO(
        @NotNull @NotBlank String name,
        String description) {
}
