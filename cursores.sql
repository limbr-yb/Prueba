Declare
	xnro number;
	Cursor c_autores Is SELECT nombre, sexo, trunc(months_between(sysdate,fecha_naci)/12) edad
	FROM autor
	order by edad;
	xnombre varchar(75);
	xsexo varchar(15);
	xedad number;
Begin
	xnro :=1;
	dbms_output.put_line('  Nro     Nombre      Sexo      Edad');
	dbms_output.put_line('========================================');
	open c_autores;
	Loop
	Fetch c_autores Into xnombre,xsexo,xedad;
	Exit WHEN c_autores%NOTFOUND;
	dbms_output.put_line(xnro|| '      '||xnombre|| '       '||xsexo|| '       '||xedad);
	xnro := xnro + 1;
	End Loop;
	Close c_autores;
End
