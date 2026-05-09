package xyz.rodran.calidato.domain.service;

import org.springframework.stereotype.Service;
import xyz.rodran.calidato.api.dto.RuleRequestDTO;
import xyz.rodran.calidato.api.dto.RuleResponseDTO;
import xyz.rodran.calidato.domain.model.Rule;
import xyz.rodran.calidato.domain.model.RuleSet;
import xyz.rodran.calidato.domain.repository.RuleRepository;
import xyz.rodran.calidato.domain.repository.RuleSetRepository;
import xyz.rodran.calidato.infra.mapper.RuleMapper;

@Service
public class RuleService {
    private final RuleRepository ruleRepository;
    private final RuleSetRepository ruleSetRepository;

    public RuleService(RuleRepository ruleRepository, RuleSetRepository ruleSetRepository) {
        this.ruleRepository = ruleRepository;
        this.ruleSetRepository = ruleSetRepository;
    }

    public RuleResponseDTO create(Long ruleSetId, RuleRequestDTO dto) {
        RuleSet ruleSet = ruleSetRepository.findById(ruleSetId)
                .orElseThrow(() -> new ResourceNotFoundException("RuleSet",ruleSetId));
        Rule rule = RuleMapper.toEntity(dto, ruleSet);
        return RuleMapper.toResponse(ruleRepository.save(rule));
    }

    public void delete(Long ruleSetId, Long id) {
        Rule rule = ruleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule", id));
        if (!ruleSetId.equals(rule.getRuleSet().getId())){
            throw new ResourceNotFoundException("Rule " + id + " not found in RuleSet " + ruleSetId);
        }
        ruleRepository.delete(rule);
    }
}
