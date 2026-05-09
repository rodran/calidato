package xyz.rodran.calidato.api.dto;

import java.time.LocalDateTime;

public record RuleSetResponseDTO(
        Long id,
        String name,
        String description
    ) {
}
