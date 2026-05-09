package xyz.rodran.calidato.infra.mapper;

import xyz.rodran.calidato.api.dto.RuleSetRequestDTO;
import xyz.rodran.calidato.api.dto.RuleSetResponseDTO;
import xyz.rodran.calidato.domain.model.RuleSet;

public class RuleSetMapper {
    private RuleSetMapper() {

    }

    public static RuleSet toEntity(RuleSetRequestDTO dto) {
        var ruleSet = new RuleSet();
        ruleSet.setName(dto.name());
        ruleSet.setDescription(dto.description());
        return ruleSet;
    }

    public static RuleSetResponseDTO toResponse(RuleSet ruleSet) {
        return new RuleSetResponseDTO(
                ruleSet.getId(),
                ruleSet.getName(),
                ruleSet.getDescription()
        );
    }


}
