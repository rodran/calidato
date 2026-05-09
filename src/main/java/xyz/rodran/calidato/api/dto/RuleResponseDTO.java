package xyz.rodran.calidato.api.dto;

import xyz.rodran.calidato.domain.model.RuleType;
import java.util.Map;

public record RuleResponseDTO(
        Long id,
        String columnName,
        RuleType ruleType,
        Map<String, Object> parameters,
        Boolean isActive,
        Long ruleSetId
    ) {
}
