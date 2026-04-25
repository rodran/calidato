package xyz.rodran.calidato.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.rodran.calidato.domain.model.Rule;

public interface RuleRepository extends JpaRepository<Rule, Long> {
}
