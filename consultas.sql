use bddvotacion;
use bddVotacionfinal;
select * from administrador;
-- Insercion de administradores --
desc administrador;
insert into administrador(idAdministrador,nombre_administrador,apellido_administrador,usuario,contrasenya) 
values (1722295134,'Fernando','Carrasco','Fernando Carrasco',1722295134);
SELECT idAdministrador,usuario, contrasenya FROM administrador WHERE usuario = 'Fernando Carrasco';

-- inserción de votantes --
select * from votante;
desc votante;
insert into votante(idVotante,nombre_votante,apellido_votante,tipo_id,carrera_votante,nivel_votante,Usuario,contraseña) 
values (1722295134,'Victor','Carrasco','ci','sistemas',4,'Victor Carrasco',1722295134);
SELECT idVotante, Usuario, contraseña FROM votante WHERE Usuario = 'Victor Carrasco';
-- para mostrar candidatos --
select * from candidato;
-- ------------------------ --
desc candidato;
-- Insertar candidatos
insert into candidato(idCandidato,nombre_candidato,apellido_candidato,carrera_candidato,nivel_candidato,tipo_id_candidato) 
values (1722513591,'Carla','Salas','Finanzas',6,'ci');
insert into candidato(idCandidato,nombre_candidato,apellido_candidato,carrera_candidato,nivel_candidato,tipo_id_candidato) 
values (1550025927,'Alberto','Plaza','Mecanica',7,'ci');
insert into candidato(idCandidato,nombre_candidato,apellido_candidato,carrera_candidato,nivel_candidato,tipo_id_candidato) 
values (1002552312,'Veronica','Zambrano','Ambiental',5,'ci');
delete  from candidato where idCandidato=2147483647;
-- Mostrar votos --
ALTER TABLE `votos` ADD COLUMN `en_blanco` tinyint(1) null;
select * from votos;
desc votos;
insert into votos(idVotos,voto,Candidato_idCandidato) values (1,1,550025927);
delete from votos where idVotos=6;
select count(idCandidato) as num_candidatos from candidato;
desc num_candidatos;
select count(Candidato_idCandidato) from votos;
select count(voto) from votos where voto = 1 ;
select count(en_blanco) as num_blancos from votos where en_blanco = 1 ;
select count(*) from votos where Candidato_idCandidato=1002552312 and voto = 1;

delete from votos where Candidato_idCandidato=1002552312;