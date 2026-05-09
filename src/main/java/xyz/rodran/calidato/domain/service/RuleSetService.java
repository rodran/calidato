package xyz.rodran.calidato.domain.service;

import org.springframework.stereotype.Service;
import xyz.rodran.calidato.api.dto.RuleSetRequestDTO;
import xyz.rodran.calidato.api.dto.RuleSetResponseDTO;
import xyz.rodran.calidato.domain.model.RuleSet;
import xyz.rodran.calidato.domain.repository.RuleSetRepository;
import xyz.rodran.calidato.infra.mapper.RuleSetMapper;

import java.util.List;

@Service
public class RuleSetService {

    private final RuleSetRepository ruleSetRepository;

    public RuleSetService(RuleSetRepository ruleSetRepository) {
        this.ruleSetRepository = ruleSetRepository;
    }

    public List<RuleSetResponseDTO> listAll() {
        return ruleSetRepository.findAll().stream()
                .map(RuleSetMapper::toResponse)
                .toList();
    }

    public RuleSetResponseDTO create(RuleSetRequestDTO dto) {
        RuleSet ruleSet = RuleSetMapper.toEntity(dto);
        return RuleSetMapper.toResponse(ruleSetRepository.save(ruleSet));
    }

    public RuleSetResponseDTO findById(Long id) {
        return RuleSetMapper.toResponse(ruleSetRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("RuleSet",id)));
    }

    public void delete(Long id) {
        RuleSet ruleSet = ruleSetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RuleSet", id));
        ruleSetRepository.delete(ruleSet);
    }
}
