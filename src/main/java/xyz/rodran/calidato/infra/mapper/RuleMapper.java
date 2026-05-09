package xyz.rodran.calidato.infra.mapper;

import xyz.rodran.calidato.api.dto.RuleRequestDTO;
import xyz.rodran.calidato.api.dto.RuleResponseDTO;
import xyz.rodran.calidato.domain.model.Rule;
import xyz.rodran.calidato.domain.model.RuleSet;

public class RuleMapper {
    private RuleMapper() {

    }

    public static Rule toEntity(RuleRequestDTO dto, RuleSet ruleSet) {
        var rule = new Rule();
        rule.setColumnName(dto.columnName());
        rule.setRuleType(dto.ruleType());
        rule.setParameters(dto.parameters());
        rule.setActive(true);
        rule.setRuleSet(ruleSet);
        return rule;
    }

    public static RuleResponseDTO toResponse(Rule rule) {
        return new RuleResponseDTO(
                rule.getId(),
                rule.getColumnName(),
                rule.getRuleType(),
                rule.getParameters(),
                rule.getActive(),
                rule.getRuleSet().getId()
        );
    }

}
