Declare
	cursor clibros IS select titulo from libro;
	xtitulo varchar(75);
	cursor cautores IS
		select a.nombre 
		from autor a, escrito_por pr, libro l
		where a.codautor=pr.codautor and pr.codlibro =l.codlibro and l.titulo=xtitulo;
	xautor varchar(75);
	xnro number;
BEGIN
	Open clibros;
	Loop
		Fetch clibros into xtitulo;
		exit when clibros%NOTFOUND;
    xnro := 1;
		dbms_output.put_line('TITULO: ' || xtitulo);
		dbms_output.put_line('   Autor(es)');
		dbms_output.put_line('   ----------');	
		Open cautores;
		Loop
			Fetch cautores into xautor;
			exit when cautores%NOTFOUND;
			dbms_output.put_line('   '||xnro || ' ' || xautor);
			xnro := xnro + 1;
		End Loop;
		close cautores;
	end Loop;
	close clibros;
END;
