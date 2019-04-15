-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
drop schema bddVotacionfinal;
-- -----------------------------------------------------
-- Schema bddVotacionfinal
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bddVotacionfinal
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bddVotacionfinal` DEFAULT CHARACTER SET utf8 ;
USE `bddVotacionfinal` ;

-- -----------------------------------------------------
-- Table `bddVotacionfinal`.`Votante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bddVotacionfinal`.`Votante` (
  `idVotante` MEDIUMINT(10) NOT NULL,
  `nombre_votante` VARCHAR(45) NULL,
  `apellido_votante` VARCHAR(45) NULL,
  `tipo_id` CHAR(2) NULL,
  `carrera_votante` VARCHAR(45) NULL,
  `nivel_votante` INT NULL,
  `Usuario` VARCHAR(45) NULL,
  `contraseña` VARCHAR(45) NULL,
  PRIMARY KEY (`idVotante`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bddVotacionfinal`.`Candidato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bddVotacionfinal`.`Candidato` (
  `idCandidato` MEDIUMINT(10) NOT NULL,
  `nombre_candidato` VARCHAR(45) NULL,
  `apellido_candidato` VARCHAR(45) NULL,
  `carrera_candidato` VARCHAR(45) NULL,
  `nivel_candidato` INT NULL,
  `tipo_id_candidato` CHAR(2) NULL,
  PRIMARY KEY (`idCandidato`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bddVotacionfinal`.`Administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bddVotacionfinal`.`Administrador` (
  `idAdministrador` INT NOT NULL,
  `nombre_administrador` VARCHAR(45) NULL,
  `apellido_administrador` VARCHAR(45) NULL,
  `usuario` VARCHAR(45) NULL,
  `contrasenya` VARCHAR(45) NULL,
  PRIMARY KEY (`idAdministrador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bddVotacionfinal`.`Votos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Votos` (
  `idVotos` INT NOT NULL AUTO_INCREMENT,
  `voto` TINYINT(1) NULL,
  `en_blanco` TINYINT(1) NULL,
  `Candidato_idCandidato` INT NOT NULL,
  PRIMARY KEY (`idVotos`, `Candidato_idCandidato`),
  INDEX `fk_Votos_Candidato1_idx` (`Candidato_idCandidato` ASC),
  UNIQUE INDEX `Candidato_idCandidato_UNIQUE` (`Candidato_idCandidato` ASC),
  CONSTRAINT `fk_Votos_Candidato1`
    FOREIGN KEY (`Candidato_idCandidato`)
    REFERENCES `bddvotacionfinal`.`Candidato` (`idCandidato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
