-- Creating the RuleSets table (Strong Entity)
CREATE TABLE rulesets (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    CONSTRAINT uk_ruleset_name UNIQUE (name)
);

-- Creating the Rules table (Weak Entity of RuleSets)
CREATE TABLE rules (
    id BIGSERIAL PRIMARY KEY,
    ruleset_id BIGINT NOT NULL,
    column_name VARCHAR(255) NOT NULL,
    rule_type VARCHAR(100) NOT NULL CHECK (rule_type IN ('ALLOWED_VALUES','BETWEEN','MIN_LENGTH','NOT_NULL','REGEX','UNIQUE')),
    parameters JSONB,
    is_active BOOLEAN DEFAULT TRUE,
    CONSTRAINT fk_rule_ruleset FOREIGN KEY (ruleset_id) REFERENCES rulesets(id) ON DELETE CASCADE
);

-- Creating the Datasets table
CREATE TABLE datasets (
    id BIGSERIAL PRIMARY KEY,
    original_file_name VARCHAR(255) NOT NULL,
    dataset_type VARCHAR(50) NOT NULL CHECK (dataset_type IN ('CSV','JSON')),
    total_rows INTEGER,
    size_bytes BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Creating the ValidationReports table (Strong Entity)
CREATE TABLE validation_reports (
    id BIGSERIAL PRIMARY KEY,
    dataset_id BIGINT NOT NULL,
    ruleset_id BIGINT NOT NULL,
    quality_score DECIMAL(5, 2), -- Ex: 99.99
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_report_dataset FOREIGN KEY (dataset_id) REFERENCES datasets(id),
    CONSTRAINT fk_report_ruleset FOREIGN KEY (ruleset_id) REFERENCES rulesets(id)
);

-- Creating the Violations table (Weak Entity of ValidationReports)
CREATE TABLE violations (
    id BIGSERIAL PRIMARY KEY,
    validation_report_id BIGINT NOT NULL,
    column_name VARCHAR(255) NOT NULL,
    rule_type VARCHAR(100) NOT NULL CHECK (rule_type IN ('ALLOWED_VALUES','BETWEEN','MIN_LENGTH','NOT_NULL','REGEX','UNIQUE')),
    row_number INTEGER NOT NULL,
    value TEXT,
    message TEXT,
    CONSTRAINT fk_violation_report FOREIGN KEY (validation_report_id) REFERENCES validation_reports(id) ON DELETE CASCADE,
    CONSTRAINT uk_violation_natural_key UNIQUE (validation_report_id, column_name, rule_type, row_number)
);

-- Indexes
CREATE INDEX idx_rule_ruleset_id ON rules(ruleset_id);
CREATE INDEX idx_report_dataset_id ON validation_reports(dataset_id);
CREATE INDEX idx_violation_report_id ON violations(validation_report_id);