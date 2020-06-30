-- liquibase formatted sql

-- changeset aaa:1
DROP TABLE IF EXISTS part;

-- changeset aaa:2
DROP TABLE IF EXISTS material;

-- changeset aaa:3
DROP TABLE IF EXISTS supplier;

-- changeset aaa:4
DROP TABLE IF EXISTS assembly;

-- changeset aaa:5
DROP TABLE IF EXISTS machine;

-- changeset aaa:6
CREATE TABLE IF NOT EXISTS machine
(
    id     VARCHAR(45) NOT NULL,
    name   VARCHAR(45) NULL,
    status VARCHAR(45) NULL,
    PRIMARY KEY (id)
);

-- changeset aaa:7
CREATE TABLE IF NOT EXISTS assembly
(
    id         VARCHAR(45) NOT NULL,
    name       VARCHAR(45) NULL,
    status     VARCHAR(45) NULL,
    machine_id VARCHAR(45) NOT NULL,
    PRIMARY KEY (id, machine_id),
    INDEX fk_assembly_machine1_idx (machine_id ASC) VISIBLE,
    CONSTRAINT fk_assembly_machine1
        FOREIGN KEY (machine_id)
            REFERENCES machine (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

-- changeset aaa:8
CREATE TABLE IF NOT EXISTS supplier
(
    id   VARCHAR(45) NOT NULL,
    name VARCHAR(45) NULL,
    PRIMARY KEY (id)
);

-- changeset aaa:9
CREATE TABLE IF NOT EXISTS material
(
    id   VARCHAR(45) NOT NULL,
    name VARCHAR(45) NULL,
    PRIMARY KEY (id)
);

-- changeset aaa:10
CREATE TABLE IF NOT EXISTS part
(
    id                VARCHAR(45) NOT NULL,
    name              VARCHAR(45) NULL,
    code_for_supplier VARCHAR(45) NULL,
    height            INT         NULL,
    width             INT         NULL,
    count             INT         NULL,
    status            VARCHAR(45) NULL,
    supplier_id       VARCHAR(45) NOT NULL,
    assembly_id       VARCHAR(45) NULL,
    machine_id        VARCHAR(45) NULL,
    material_id       VARCHAR(45) NOT NULL,
    PRIMARY KEY (id, material_id),
    INDEX fk_part_supplier_idx (supplier_id ASC) VISIBLE,
    INDEX fk_part_assembly1_idx (assembly_id ASC) VISIBLE,
    INDEX fk_part_machine1_idx (machine_id ASC) VISIBLE,
    INDEX fk_part_material1_idx (material_id ASC) VISIBLE,
    CONSTRAINT fk_part_supplier
        FOREIGN KEY (supplier_id)
            REFERENCES supplier (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT fk_part_assembly1
        FOREIGN KEY (assembly_id)
            REFERENCES assembly (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT fk_part_machine1
        FOREIGN KEY (machine_id)
            REFERENCES machine (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT fk_part_material1
        FOREIGN KEY (material_id)
            REFERENCES material (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);