use sistema_venta;

INSERT INTO UBIGEO 
	(CODUBI,DISUBI,PROUBI,DEPUBI)
    values
		('140409','Nuevo Imperial','Cañete','Lima');

INSERT INTO CATEGORIA
	(CODCAT,DESCAT)
    values
		('C001', 'Frutas'),
        ('C002', 'Comida'),
        ('C003', 'Tecnologia'),
        ('C004', 'Instrumentos'),
        ('C005', 'Muebles'),
        ('C006', 'Vestuario');
                
describe persona;

select * from persona; 


/*Insertar Usuario*/
INSERT INTO PERSONA
	(NOMPER,APEPER,RUCDNIPER,FECNAC,UBIPER,DIRPER,TELPER,GENPER,USEPER,CONPER,TIPPER,ESTAPER)
	values
		('Jose Luis', 'Quispe Luyo', '123456788','2000/11/19','140409','Mz. 10 Lt 10','123456789','M', 'Jose',sha1(md5('contra')),'U','A');


/*Insertar Clientes*/
INSERT INTO PERSONA
	(NOMPER,APEPER,RUCDNIPER,GENPER,TIPPER,ESTAPER)
	values
		('Jose Luis', 'Quispe Luyo1','12345678','M','C','A');



insert into UNIDAD
	(DESUNI)
    values
		('Unidad'),
		('Centimetros'),
        ('Metros'),
        ('Kilometros'),
        ('Kilogramos'),
        ('Gramos');

INSERT INTO PRODUCTO
	(CODPRO,DESPRO,CODUNI,PREPRO,CODCAT)
    VALUES
		('F001','Audifono',1, 40.00, 'C003');
