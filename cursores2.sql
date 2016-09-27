Declare
	xnro number;
	Cursor c_libros Is
		select l.titulo, l.nroalmacen, a.direccion, l.stock
		from libro l, almacen a
		where l.nroalmacen=a.nroalmacen
		order by l.titulo;
	xtitulo varchar2(75);
	xnroalmacen number;
	xdireccion varchar2(50);
	xstock number;
Begin
	xnro :=1;
	dbms_output.put_line('  Nro      Titulo');
	dbms_output.put_line('====================================');
	open c_libros;
	Loop
	Fetch c_libros Into xtitulo, xnroalmacen, xdireccion, xstock;
	Exit WHEN c_libros%NOTFOUND;
	dbms_output.put_line(xnro|| '     '||xtitulo);
	dbms_output.put_line('          Almacén: '||xnroalmacen|| '      Direccion: '||xdireccion);

	IF xstock > 20 THEN
		dbms_output.put_line('          Existencia: '||xstock);
	ELSE
		dbms_output.put_line('          Existencia: '||xstock || '  SOLICITAR MAS LIBROS');
	END IF;
	dbms_output.put_line(' ');
	xnro := xnro + 1;
	End Loop;
	Close c_libros;
End
