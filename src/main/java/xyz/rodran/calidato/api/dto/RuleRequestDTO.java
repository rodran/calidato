package xyz.rodran.calidato.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import xyz.rodran.calidato.domain.model.RuleType;
import java.util.Map;

public record RuleRequestDTO(
        @NotNull @NotBlank String columnName,
        @NotNull RuleType ruleType,
        @NotNull Map<String, Object> parameters
    ) {
}
