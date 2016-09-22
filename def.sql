

create or replace procedure ficha_proyecto(xidproy in varchar2,
				 xdescripcion out varchar2, 
				 xdocente out varchar2, 
				 xnrojurados out number,
				 xnota_max out number,
				 xnota_min out number,
				 xnota_promedio out number,
				 xnro_est_masculino out number,
				 xnro_est_femenino out number,
				 xubicacion out varchar2,
				 xnrostand out number)
is
begin
	select descripcion into xdescripcion from proyecto where idproy=xidproy;
	select (pe.apellido || ' ' || pe.nombre) into xdocente from proyecto pr, persona pe where pr.idproy=xidproy and pr.docresp=pe.codigo;
	select count(*) into xnrojurados from califica where idproy='06TIM' group by idproy;
	select max(nota) into xnota_max from califica where idproy=xidproy;
	select min(nota) into xnota_min from califica where idproy=xidproy;
	select round(avg(nota),7) into xnota_promedio from califica where idproy=xidproy;
	select count(*) into xnro_est_masculino from estudiante e, persona p where e.idproy=xidproy and p.sexo='Masculino' and e.codigo=p.codigo;
	select count(*) into xnro_est_femenino from estudiante e, persona p where e.idproy=xidproy and p.sexo='Femenino' and e.codigo=p.codigo;
	select (p.idamb || ' ' || a.ubicacion) into xubicacion from proyecto p, ambiente a where p.idproy=xidproy and p.idamb=a.idamb;
	select nrostand into xnrostand from proyecto where idproy=xidproy;
end;

