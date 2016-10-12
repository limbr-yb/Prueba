create TABLE alumno
(
    id_alumno int not null,
    nombre varchar(20),
    apellido varchar(20),
    departamento varchar(20),
    usuario varchar(20),
    password varchar(20),
    primary key(id_alumno)
);

create TABLE materia
(
    id_materia int not null,
    descripcion varchar(50),
    primary key(id_materia)
);

create TABLE alumno_materia
(
    gestion int,
    semestre int,
    id_alumno int not null,
    id_materia int not null,
    nota numeric,
    primary key(id_alumno, id_materia),
    foreign key(id_alumno) references alumno,
    foreign key(id_materia) references materia  
);

insert into alumno values (1,'M','S','D2','01','123');
insert into alumno values (2,'A','J','D3','02','456');
insert into alumno values (3,'M','J','D2','03','789');

insert into materia values(1,'INF-111');
insert into materia values(2,'INF-123');

insert into alumno_materia values(2016,1,1,1,100);
insert into alumno_materia values(2016,1,1,2,70);

select *
from INFORMATION_SCHEMA.COLUMNS
where TABLE_NAME='alumno'

select * from alumno