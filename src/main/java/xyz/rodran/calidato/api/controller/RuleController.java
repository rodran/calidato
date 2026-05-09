package xyz.rodran.calidato.api.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.rodran.calidato.api.dto.RuleRequestDTO;
import xyz.rodran.calidato.api.dto.RuleResponseDTO;
import xyz.rodran.calidato.domain.service.RuleService;

@RestController
public class RuleController {

    private final RuleService ruleService;

    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping("/rulesets/{ruleSetId}/rules")
    public ResponseEntity<RuleResponseDTO> create(@PathVariable(value = "ruleSetId") Long ruleSetId,
                                                  @RequestBody @Valid RuleRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ruleService.create(ruleSetId, requestDTO));
    }

    @DeleteMapping("/rulesets/{ruleSetId}/rules/{ruleId}")
    public ResponseEntity<Object> delete(@PathVariable(value = "ruleSetId") Long ruleSetId,
                                         @PathVariable(value = "ruleId") Long ruleId) {
        ruleService.delete(ruleSetId, ruleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
