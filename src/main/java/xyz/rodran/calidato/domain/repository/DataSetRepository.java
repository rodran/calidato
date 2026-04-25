package xyz.rodran.calidato.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.rodran.calidato.domain.model.DataSet;

public interface DataSetRepository extends JpaRepository<DataSet, Long> {
}
