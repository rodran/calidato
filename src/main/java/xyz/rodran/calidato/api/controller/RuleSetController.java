package xyz.rodran.calidato.api.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.rodran.calidato.api.dto.RuleSetRequestDTO;
import xyz.rodran.calidato.api.dto.RuleSetResponseDTO;
import xyz.rodran.calidato.domain.service.RuleSetService;

import java.util.List;

@RestController
public class RuleSetController {

    private final RuleSetService ruleSetService;

    public RuleSetController(RuleSetService ruleSetService) {
        this.ruleSetService = ruleSetService;
    }

    @PostMapping("/rulesets")
    public ResponseEntity<RuleSetResponseDTO> create(@RequestBody @Valid RuleSetRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ruleSetService.create(requestDTO));
    }

    @GetMapping("/rulesets")
    public ResponseEntity<List<RuleSetResponseDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(ruleSetService.listAll());
    }

    @GetMapping("/rulesets/{id}")
    public ResponseEntity<RuleSetResponseDTO> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(ruleSetService.findById(id));
    }

    @DeleteMapping("/rulesets/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
        ruleSetService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
