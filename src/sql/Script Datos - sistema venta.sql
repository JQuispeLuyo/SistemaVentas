use sistema_venta;

INSERT INTO UBIGEO 
	(CODUBI,DISUBI,PROUBI,DEPUBI)
    values
		('140409','Nuevo Imperial','Cañete','Lima');

INSERT INTO CATEGORIA
	(CODCAT,NOMCAT)
    values
		('C001', 'Frutas'),
        ('C002', 'Comida'),
        ('C003', 'Tecnologia'),
        ('C004', 'Instrumentos'),
        ('C005', 'Muebles'),
        ('C006', 'Vestuario');
        
INSERT INTO EMPRESA
	(NOMEMP,RUCEMP,RAZSOCEMP,TELF1EMP,TELF2EMP,CORREMP,WEBEMP,TIPEMP,ESTEMP,UBIGEO_CODUBI)
    VALUES
		('Mi Empresa','12345678801','Razon social','123456789',null,'mi_empresa@outlook.com','www.miEmpresa.com','A','A','140409'),
		('Compunet','12345678800','Razon social1','123456788',null,'cumpunet@outlook.com','www.compunet.com','A','A','140409');
        

INSERT INTO PERSONA
	(NOMPER,APEPER,RUCPER,DNIPER,FECNAC,UBIPER,DIRPER,TELPER,CORPER,GENPER,USEPER,CONPER,TIPPER,ESTAPER,EMPRESA_CODEMP)
	values
		('Jose Luis', 'Quispe Luyo', '12345678900','12345678','2000/11/19','140409','Mz. 10 Lt 10','123456789','jq_00@outlook.com','M', 'Jose',sha1(md5('contra')),'E','A',1),
        ('Jose Luis1', 'Quispe Luyo1', '12345678901','12345677','2000/11/19','140409','Mz. 10 Lt 10','123456789','jq_01@outlook.com','M', 'Jose1',sha1(md5('contra1')),'E','A',1),
        ('Jose Luis2', 'Quispe Luyo2', '12345678902','12345676','2000/11/19','140409','Mz. 10 Lt 10','123456789','jq_02@outlook.com','M',null,null,'P','A',2),
        ('Jose Luis3', 'Quispe Luyo3', '12345678903','12345675','2000/11/19','140409','Mz. 10 Lt 10','123456789',null,'M',null,null,'C','A',null),
        ('Jose Luis4', 'Quispe Luyo4', '12345678904','12345674','2000/11/19','140409','Mz. 10 Lt 10','123456789',null,'M',null,null,'C','A',null),
        ('Jose Luis5', 'Quispe Luyo5', '12345678905','12345673','2000/11/19','140409','Mz. 10 Lt 10','123456789',null,'M',null,null,'C','A',null);

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



SELECT PRODUCTO.CODPRO, PRODUCTO.DESPRO, UNIDAD.DESUNI,PREPRO, CATEGORIA.NOMCAT
	FROM PRODUCTO 
    INNER JOIN UNIDAD ON PRODUCTO.CODUNI = UNIDAD.CODUNI
    INNER JOIN CATEGORIA ON PRODUCTO.CODCAT = CATEGORIA.CODCAT;
    

show errors;

describe PRODUCTO; 
/*
DELIMITER //
CREATE PROCEDURE INSERTAR_PRODUCTO(
	IN	
	_CODPRO	char(4),
	_DESPRO	varchar(100),
	_CODUNI	int(11),
	_PREPRO	decimal(10,2),
	_CODCAT	char(4)
)BEGIN

    INSERT INTO PRODUCTO
	(CODPRO,DESPRO,CODUNI,PREPRO,CODCAT)
    VALUES
		(_CODPRO,_DESPRO,_CODUNI, _PREPRO, _CODCAT);
        
END

//DELIMITER ;

CALL INSERTAR_PRODUCTO('FCC1','Audifono',1, 40.00, 'C003');

*/ 


/*
DELIMITER //
CREATE PROCEDURE EDITAR_PRODUCTO(
	IN	
	_CODPRO	char(4),
	_DESPRO	varchar(100),
	_CODUNI	int(11),
	_PREPRO	decimal(10,2),
	_CODCAT	char(4)
)BEGIN
	
    Update PRODUCTO set DESPRO=_DESPRO, CODUNI=_CODUNI, PREPRO=_PREPRO, CODCAT=_CODCAT where CODPRO=_CODPRO;
    
END;

CALL EDITAR_PRODUCTO('FCC1','Audifono',1, 10.00, 'C003');

//DELIMITER ;*/



/*
DELIMITER //

CREATE PROCEDURE MOSTRAR_PRODUCTO()
BEGIN

    SELECT CODPRO,DESPRO,DESUNI,PREPRO, NOMCAT
		FROM PRODUCTO
		INNER JOIN UNIDAD 
			ON PRODUCTO.CODUNI = UNIDAD.CODUNI
		INNER JOIN CATEGORIA 
			ON PRODUCTO.CODCAT = CATEGORIA.CODCAT;
		
        
END;

CALL MOSTRAR_PRODUCTO();

//DELIMITER ;*/


drop PROCEDURE FILTRAR_PRODUCTO;

DELIMITER //
CREATE PROCEDURE FILTRAR_PRODUCTO(_opcion char (1), _dato varchar (100))
BEGIN
	IF _opcion = '1' THEN
		
        SELECT CODPRO,DESPRO,DESUNI,PREPRO, NOMCAT
		FROM PRODUCTO
		INNER JOIN UNIDAD 
			ON PRODUCTO.CODUNI = UNIDAD.CODUNI
		INNER JOIN CATEGORIA 
			ON PRODUCTO.CODCAT = CATEGORIA.CODCAT
		WHERE NOMCAT like _dato;
        
     ELSEIF _opcion = 2 then
     
		SELECT CODPRO,DESPRO,DESUNI,PREPRO, NOMCAT
		FROM PRODUCTO
		INNER JOIN UNIDAD 
			ON PRODUCTO.CODUNI = UNIDAD.CODUNI
		INNER JOIN CATEGORIA 
			ON PRODUCTO.CODCAT = CATEGORIA.CODCAT
		WHERE DESPRO like _dato;
	END IF;
END;

CALL FILTRAR_PRODUCTO('1', '%tecnologia%');

//DELIMITER ;



