CREATE DATABASE `colombia`;

use colombia;

CREATE TABLE `departamento` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(150) NOT NULL,
	`codigo` INT NOT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_general_ci'
;

CREATE TABLE `municipio` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`departamento_id` INT NOT NULL,
	`nombre` VARCHAR(150) NOT NULL,
	`codigo` INT NOT NULL,
	`habitantes` INT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `FK_municipio_departamento_id` FOREIGN KEY (`departamento_id`) REFERENCES `departamento` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT
)
COLLATE='utf8mb4_general_ci'
;


-- CRUD

-- C -> Create
INSERT INTO colombia.departamento (nombre, codigo) VALUES ('Antioquia', 5);

INSERT INTO colombia.departamento (nombre, codigo) VALUES ('Bolivar', 13);
INSERT INTO colombia.departamento (nombre, codigo) VALUES ('Caldas', 17);
INSERT INTO colombia.departamento (nombre, codigo) VALUES ('Cauca', 19);
INSERT INTO colombia.departamento (nombre, codigo) VALUES ('Cesar', 20);
INSERT INTO colombia.departamento (nombre, codigo) VALUES ('Huila', 41);


INSERT INTO `colombia`.`municipio` (`departamento_id`, `nombre`, `codigo`, `habitantes`) VALUES ('1', 'Medellin', '1', '2000000');
INSERT INTO `colombia`.`municipio` (`departamento_id`, `nombre`, `codigo`) VALUES ('2', 'ññññ', '1000');


-- U -> Update
UPDATE `colombia`.`municipio` SET `departamento_id`='1', `nombre`='Abejorral', `codigo`='2', `habitantes`='500000' WHERE  `id`=3;
UPDATE `colombia`.`municipio` SET `habitantes`='2000001' WHERE  `id`=2;
UPDATE municipio set habitantes=2000002 where id = 2;

-- D -> Delete
INSERT INTO `colombia`.`municipio` (`departamento_id`, `nombre`, `codigo`) VALUES ('2', 'ññññ', '1000');
INSERT INTO `colombia`.`municipio` (`departamento_id`, `nombre`, `codigo`) VALUES ('2', 'AAAA', '1000');
INSERT INTO `colombia`.`municipio` (`departamento_id`, `nombre`, `codigo`) VALUES ('2', 'BBBB', '1000');
INSERT INTO `colombia`.`municipio` (`departamento_id`, `nombre`, `codigo`) VALUES ('2', '1234', '1000');
INSERT INTO `colombia`.`municipio` (`departamento_id`, `nombre`, `codigo`) VALUES ('2', '1111', '1000');
INSERT INTO `colombia`.`municipio` (`departamento_id`, `nombre`, `codigo`) VALUES ('2', '2222', '1000');


DELETE FROM `colombia`.`municipio` WHERE  `id`=9;
DELETE FROM `colombia`.`municipio` WHERE  `id`=8;
DELETE FROM `colombia`.`municipio` WHERE  `id`=7;
DELETE FROM `colombia`.`municipio` WHERE  `id`=6;
DELETE FROM `colombia`.`municipio` WHERE  `id`=5;
DELETE FROM `colombia`.`municipio` WHERE  `id`=4;


-- R -> Read
select * from departamento;