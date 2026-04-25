package xyz.rodran.calidato.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.rodran.calidato.domain.model.Violation;

public interface ViolationRepository extends JpaRepository<Violation, Long> {
}
