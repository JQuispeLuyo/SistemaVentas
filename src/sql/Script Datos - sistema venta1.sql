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

/*Insertar Clientes*/
INSERT INTO PERSONA
	(NOMPER,APEPER,RUCDNIPER,UBIPER,DIRPER,GENPER,TIPPER,ESTAPER)
	values
		('Jose Luis1', 'Quispe Luyo1','12345678','140409','Mz. 10 Lt 10','M','C','A'),
        ('Jose Luis2', 'Quispe Luyo2','12345677','140409','Mz. 10 Lt 10','M','C','A'),
        ('Jose Luis3', 'Quispe Luyo3','12345673','140409','Mz. 10 Lt 10','M','C','A');

/*Insertar Usuario*/
INSERT INTO PERSONA
	(NOMPER,APEPER,RUCDNIPER,FECNAC,UBIPER,DIRPER,TEL1PER,GENPER,USEPER,CONPER,TIPPER,ESTAPER)
	values
		('Jose Luis', 'Quispe Luyo', '12345678900','2000/11/19','140409','Mz. 10 Lt 10','123456789','M', 'Jose',sha1(md5('contra')),'E','A');


insert into UNIDAD
	(DESUNI)
    values
		('Unidad'),
		('centimetros'),
        ('metros'),
        ('kilometros'),
        ('Kilogramos'),
        ('gramos');

INSERT INTO PRODUCTO
	(CODPRO,DESPRO,CODUNI,PREPRO,CODCAT)
    VALUES
		('F001','Audifono',1, 40.00, 'C003');



SELECT PRODUCTO.CODPRO, PRODUCTO.DESPRO, UNIDAD.DESUNI,PREPRO, CATEGORIA.DESCAT
	FROM PRODUCTO 
    INNER JOIN UNIDAD ON PRODUCTO.CODUNI = UNIDAD.CODUNI
    INNER JOIN CATEGORIA ON PRODUCTO.CODCAT = CATEGORIA.CODCAT;
    

show errors;


describe PRODUCTO; 

DELIMITER //
/*CREATE PROCEDURE INSERTAR_PRODUCTO(
	IN	
	_CODPRO	char(4),
    _CODCAT	char(4),
	_DESPRO	varchar(100),
	_PREPRO	decimal(10,2),
    _CODUNI	int(11)
	
)BEGIN

    INSERT INTO PRODUCTO
	(CODPRO,CODCAT,DESPRO,PREPRO,CODUNI)
    VALUES
		(_CODPRO,_CODCAT,_DESPRO, _PREPRO,_CODUNI);
        
END;

CALL INSERTAR_PRODUCTO('FCC1','C003','Audifono', 40.00,1);

//DELIMITER ;*/


DELIMITER //
/*CREATE PROCEDURE EDITAR_PRODUCTO(
	IN	
	_CODPRO	char(4),
    _CODCAT	char(4),
	_DESPRO	varchar(100),
	_PREPRO	decimal(10,2),
    _CODUNI	int(11)
)BEGIN
	
    Update PRODUCTO set CODCAT=_CODCAT, DESPRO=_DESPRO, PREPRO=_PREPRO, CODUNI=_CODUNI where CODPRO=_CODPRO;
    
END;

CALL EDITAR_PRODUCTO('FCC1','C003','Audifono',10.00,1);

//DELIMITER ;*/


DELIMITER //
/*CREATE PROCEDURE ELIMINAR_PRODUCTO(_CODPRO char (4))
BEGIN

    delete from PRODUCTO where CODPRO = _CODPRO;
    
END;

CALL ELIMINAR_PRODUCTO('F001');

//DELIMITER ;*/


DELIMITER //
/*CREATE PROCEDURE MOSTRAR_PRODUCTO()
BEGIN

    SELECT CODPRO,DESPRO,DESUNI,PREPRO, DESCAT
		FROM PRODUCTO
		INNER JOIN UNIDAD 
			ON PRODUCTO.CODUNI = UNIDAD.CODUNI
		INNER JOIN CATEGORIA 
			ON PRODUCTO.CODCAT = CATEGORIA.CODCAT;
		
        
END;

CALL MOSTRAR_PRODUCTO();

//DELIMITER ;*/


DELIMITER //
/*CREATE PROCEDURE FILTRAR_PRODUCTO(_opcion char (1), _dato varchar (100))
BEGIN
	IF _opcion = '1' THEN
		
        SELECT CODPRO,DESPRO,DESUNI,PREPRO, DESCAT
		FROM PRODUCTO
		INNER JOIN UNIDAD 
			ON PRODUCTO.CODUNI = UNIDAD.CODUNI
		INNER JOIN CATEGORIA 
			ON PRODUCTO.CODCAT = CATEGORIA.CODCAT
		WHERE DESCAT like _dato;
        
     ELSEIF _opcion = 2 then
     
		SELECT CODPRO,DESPRO,DESUNI,PREPRO, DESCAT
		FROM PRODUCTO
		INNER JOIN UNIDAD 
			ON PRODUCTO.CODUNI = UNIDAD.CODUNI
		INNER JOIN CATEGORIA 
			ON PRODUCTO.CODCAT = CATEGORIA.CODCAT
		WHERE DESPRO like _dato;
	END IF;
END;

CALL FILTRAR_PRODUCTO('1', '%tecnologia%');

//DELIMITER ;*/



describe PERSONA;

DELIMITER //
/*CREATE PROCEDURE INSERTAR_USUARIO(
	IN	
	_NOMPER	varchar(80),
	_APEPER	varchar(80),
	_RUCDNIPER varchar(11),
	_FECNAC	date,
	_UBIPER	char(6),
	_DIRPER	varchar(30),
	_TEL1PER char(9),
	_GENPER	char(1),
	_USEPER	varchar(30),
	_CONPER	varchar(100),
	_TIPPER	char(1),
	_ESTAPER char(1)
)BEGIN

    INSERT INTO PERSONA
		(NOMPER,APEPER,RUCDNIPER,FECNAC,UBIPER,DIRPER,TEL1PER,GENPER,USEPER,CONPER,TIPPER,ESTAPER)
    VALUES
		(_NOMPER,_APEPER,_RUCDNIPER,_FECNAC,_UBIPER,_DIRPER,_TEL1PER,_GENPER,_USEPER,_CONPER,_TIPPER,_ESTAPER);
        
END;

CALL INSERTAR_USUARIO('Jose Luis', 'Quispe Luyo', '12345678900','2000/11/19','140409','Mz. 10 Lt 10','123456789','M', 'Jose1',sha1(md5('contra')),'E','A');

//DELIMITER ;*/


DELIMITER //
/*CREATE PROCEDURE EDITAR_USUARIO_DATOS(
	IN	
    _CODPER int(11),
	_NOMPER	varchar(80),
	_APEPER	varchar(80),
	_RUCDNIPER varchar(11),
	_FECNAC	date,
	_UBIPER	char(6),
	_DIRPER	varchar(30),
	_TEL1PER char(9),
	_GENPER	char(1),
	_TIPPER	char(1),
	_ESTAPER char(1)
    
)BEGIN
	Update 
		PERSONA 
        
		set NOMPER=_NOMPER, 
			APEPER=_APEPER, 
            RUCDNIPER=_RUCDNIPER,
            FECNAC=_FECNAC,
            UBIPER=_UBIPER,
			DIRPER=_DIRPER,
            TEL1PER=_TEL1PER,
            GENPER=_GENPER,
            TIPPER=_TIPPER,
            ESTAPER=_ESTAPER
		where CODPER=_CODPER;
END;

CALL EDITAR_USUARIO_DATOS(12,'Jose Luis4', 'Quispe Luyo', '12345678900','2000/11/19','140409',
							'Mz. 10 Lt 10','123456789','M','E','A');
				
//DELIMITER ;*/

select * from persona;
DELIMITER //
/*CREATE PROCEDURE EDITAR_USUARIO_LOGIN(
	IN	
    _CODPER int(11),
	_USEPER varchar(30),
	_CONPER varchar (100)
    
)BEGIN
	Update 
		PERSONA 
		set
            USEPER=_USEPER,
            CONPER=_CONPER
            
		where CODPER=_CODPER;
END;

CALL EDITAR_USUARIO_LOGIN(12,'Jose1',sha1(md5('contra')));

//DELIMITER ;*/

delete from persona where CODPER = 24;

DELIMITER //
CREATE PROCEDURE ELIMINAR_USUARIO(_CODPER int, _ESTAPER char(1))
BEGIN

	Update 
		PERSONA 
		set
            ESTAPER=_ESTAPER
            
		where CODPER=_CODPER;
    
END;

CALL ELIMINAR_USUARIO(23, 'B');

//DELIMITER ;*/


select * from persona;



DELIMITER //
/*CREATE PROCEDURE VERIFICAR_EXISTENCIA_USUARIO_LOGIN(_USEPER varchar(30))
BEGIN

    SELECT USEPER FROM PERSONA WHERE USEPER=_USEPER;
		
END;

CALL VERIFICAR_EXISTENCIA_USUARIO_LOGIN('Jose');

//DELIMITER ;*/



DELIMITER //
/*CREATE PROCEDURE VERIFICAR_EXISTENCIA_USUARIO(_RUCDNIPER varchar(30))
BEGIN

    SELECT RUCDNIPER FROM PERSONA WHERE RUCDNIPER = _RUCDNIPER;
		
END;

CALL VERIFICAR_EXISTENCIA_USUARIO('12345678900');

//DELIMITER ;*/



DELIMITER //
/*CREATE PROCEDURE MOSTRAR_USUARIO()
BEGIN

    SELECT CODPER, NOMPER,APEPER,RUCDNIPER,FECNAC,UBIPER,DIRPER,TEL1PER,GENPER, USEPER
		FROM PERSONA
		WHERE ESTAPER = 'A' AND TIPPER = 'U';
		
END;

CALL MOSTRAR_USUARIO();

//DELIMITER ;*/



DELIMITER //
/*CREATE PROCEDURE FILTRAR_USUARIO(

	_opcion char(1),
    _dato varchar (100)
    
)BEGIN
	IF _opcion = '1' THEN
    
		SELECT CODPER, NOMPER,APEPER,RUCDNIPER,TEL1PER,GENPER,USEPER
			FROM PERSONA
		WHERE NOMPER like _dato;
        
	 ELSEIF _opcion = '2' THEN
		SELECT CODPER, NOMPER,APEPER,RUCDNIPER,TEL1PER,GENPER,USEPER
			FROM PERSONA
		WHERE APEPER like _dato;
        
     ELSEIF _opcion = '3' THEN
		SELECT CODPER, NOMPER,APEPER,RUCDNIPER,TEL1PER,GENPER,USEPER
			FROM PERSONA
		WHERE RUCDNIPER like _dato;
        
	 ELSEIF _opcion = '4' THEN
		SELECT CODPER, NOMPER,APEPER,RUCDNIPER,TEL1PER,GENPER,USEPER
			FROM PERSONA
		WHERE TEL1PER like _dato;
        
	END IF;
END;

CALL FILTRAR_USUARIO('4', '%1234%');

//DELIMITER ;*/


