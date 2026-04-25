package xyz.rodran.calidato.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "violations")
public class Violation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "validation_report_id", nullable = false)
    private ValidationReport validationReport;

    @Column(name = "column_name")
    private String columnName;

    @Enumerated(EnumType.STRING)
    @Column(name = "rule_type")
    private RuleType type;

    @Column(name = "row_number")
    private Integer row;

    @Column(name = "value")
    private String value;

    @Column(name = "message")
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ValidationReport getValidationReport() {
        return validationReport;
    }

    public void setValidationReport(ValidationReport validationReport) {
        this.validationReport = validationReport;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public RuleType getType() {
        return type;
    }

    public void setType(RuleType type) {
        this.type = type;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
