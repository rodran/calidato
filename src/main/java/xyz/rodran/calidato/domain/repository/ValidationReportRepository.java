package xyz.rodran.calidato.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.rodran.calidato.domain.model.ValidationReport;

public interface ValidationReportRepository extends JpaRepository<ValidationReport, Long> {
}
