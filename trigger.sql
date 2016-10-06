CREATE TABLE histo_cliente(
codcliente_ante number,
codcliente_act number,
nombre_ante varchar2(75),
nombre_act varchar2(75),
direccion_ante varchar2(100),
direccion_act varchar2(100),
telefono_ante varchar2(15),
telefono_act varchar2(15),
email_ante varchar2(25),
email_act varchar2(25),
sexo_ante varchar2(15),
sexo_act varchar2(15),
fecha_naci_ante date,
fecha_naci_act date,
fecha_modi date
);

********************************

CREATE OR REPLACE TRIGGER tr_historico_cliente
AFTER UPDATE ON cliente
FOR EACH ROW
DECLARE
BEGIN
	INSERT INTO histo_cliente values
	(
		:OLD.codcliente,
		:NEW.codcliente,
		:OLD.nombre,
		:NEW.nombre,
		:OLD.direccion,
		:NEW.direccion,
		:OLD.telefono,
		:NEW.telefono,
		:OLD.email,
		:NEW.email,
		:OLD.sexo,
		:NEW.sexo,
		:OLD.fecha_naci,
		:NEW.fecha_naci,
		sysdate
	);
END;
