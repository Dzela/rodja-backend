-- -----------------------------------------------------
-- Drop tables before creating new ones
-- -----------------------------------------------------

DROP TABLE IF EXISTS `part` ;
DROP TABLE IF EXISTS `assembly` ;
DROP TABLE IF EXISTS `supplier` ;

-- -----------------------------------------------------
-- Table `assembly`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `assembly` (
  `id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `number_of_parts` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supplier`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `supplier` (
  `id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `part`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `part` (
  `id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `material` VARCHAR(45) NOT NULL,
  `height` INT NOT NULL,
  `width` INT NOT NULL,
  `depth` INT NOT NULL,
  `code_for_supplier` VARCHAR(45) NOT NULL,
  `count` INT NOT NULL,
  `assembly_id` VARCHAR(45) NOT NULL,
  `supplier_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `assembly_id`, `supplier_id`),
  INDEX `fk_part_assembly_idx` (`assembly_id` ASC) VISIBLE,
  INDEX `fk_part_supplier_idx` (`supplier_id` ASC) VISIBLE,
  CONSTRAINT `fk_part_assembly`
    FOREIGN KEY (`assembly_id`)
    REFERENCES `assembly` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_part_supplier`
    FOREIGN KEY (`supplier_id`)
    REFERENCES `supplier` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
