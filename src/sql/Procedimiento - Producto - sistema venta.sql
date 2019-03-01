describe PRODUCTO; 

DELIMITER //
CREATE PROCEDURE INSERTAR_PRODUCTO(
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
CREATE PROCEDURE EDITAR_PRODUCTO(
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
CREATE PROCEDURE ELIMINAR_PRODUCTO(_CODPRO char (4))
BEGIN

    delete from PRODUCTO where CODPRO = _CODPRO;
    
END;

CALL ELIMINAR_PRODUCTO('FCC1');

//DELIMITER ;*/


DELIMITER //
CREATE PROCEDURE MOSTRAR_PRODUCTO()
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
CREATE PROCEDURE FILTRAR_PRODUCTO(_opcion char (1), _dato varchar (100))
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