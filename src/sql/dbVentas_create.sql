DROP DATABASE sistema_venta;
CREATE DATABASE sistema_venta;
USE sistema_venta;

CREATE TABLE CATEGORIA (
    CODCAT char(4) NOT NULL COMMENT 'Contiene el identificador de las categorias de los productos',
    NOMCAT varchar(30) NOT NULL COMMENT 'Contiene el nombre de la categoria',
    CONSTRAINT CATEGORIA_pk PRIMARY KEY (CODCAT)
) COMMENT 'Contiene la categoria de los productos';

-- Table: EMPRESA
CREATE TABLE EMPRESA (
    CODEMP int NOT NULL AUTO_INCREMENT COMMENT 'Contiene el codigo de la empresa',
    NOMEMP varchar(100) NOT NULL COMMENT 'Contiene el nombre de la empresa',
    RUCEMP char(11) NOT NULL COMMENT 'Contiene el ruc de la empresa',
    RAZSOCEMP varchar(150) NOT NULL COMMENT 'Contiene la razon social de la empresa',
    TELF1EMP char(9) NOT NULL COMMENT 'Contiene el telefono 1 de la empresa',
    TELF2EMP char(9) NULL COMMENT 'Contiene el telefono 2 de la empresa',
    CORREMP varchar(50) NULL COMMENT 'Contiene el correo de la empresa',
    WEBEMP varchar(100) NULL COMMENT 'Contiene la direcion web de la empresa',
    TIPEMP char(1) NOT NULL COMMENT 'Contiene el tipo de empresa
A = Empresa propia
B = Otras empresas
',
    ESTEMP char(1) NOT NULL COMMENT 'Contiene el estado de la empresa
A = Activo
B = Inactivo',
    UBIGEO_CODUBI char(6) NOT NULL,
    CONSTRAINT EMPRESA_pk PRIMARY KEY (CODEMP)
);

-- Table: PERSONA
CREATE TABLE PERSONA (
    CODPER int NOT NULL AUTO_INCREMENT COMMENT 'Contiene el identificador de las personas',
    NOMPER varchar(80) NOT NULL COMMENT 'Contiene el nombre de la persona',
    APEPER varchar(80) NOT NULL COMMENT 'Contiene el apellido de la persona',
    RUCPER char(11) NULL COMMENT 'Contiene el RUC de la persona',
    DNIPER char(8) NULL COMMENT 'Contiene el DNI de la persona',
    FECNAC date NOT NULL COMMENT 'Contiene la fechad e nacimiento de la persona',
    UBIPER char(6) NOT NULL COMMENT 'Contiene la direcion de las personas',
    DIRPER varchar(30) NOT NULL COMMENT 'Contiene las calles donde vive la persona',
    TELPER char(9) NULL COMMENT 'Contiene el primer telefono de las personas',
    CORPER varchar(120) NULL COMMENT 'Contiene el correo del proveedor',
    GENPER char(1) NOT NULL,
    USEPER varchar(30) NULL COMMENT 'Contiene el usuario de la persona',
    CONPER varchar(100) NULL COMMENT 'Contiene la contraseña de la persona',
    TIPPER char(1) NULL COMMENT 'Contiene el tipo de persona (Cliente, proveedor)',
    ESTAPER char(1) NOT NULL COMMENT 'Contiene el estado de la persona
A = Activo
B = Inactivo',
    EMPRESA_CODEMP int NULL,
    CONSTRAINT PERSONA_pk PRIMARY KEY (CODPER)
) COMMENT 'Contiene los datos de los clientes y proveedores';

-- Table: PRODUCTO
CREATE TABLE PRODUCTO (
    CODPRO char(4) NOT NULL COMMENT 'Contiene el identificador de los productos ',
    DESPRO varchar(100) NULL COMMENT 'Contiene la descripción del producto',
    CODUNI int NOT NULL COMMENT 'Contiene el codigo de la unidades',
    PREPRO decimal(10,2) NOT NULL COMMENT 'Contiene el precio de los productos',
    CODCAT char(4) NOT NULL COMMENT 'Contiene el codigo de categoria',
    CONSTRAINT PRODUCTO_pk PRIMARY KEY (CODPRO)
) COMMENT 'Contienes los productos a vender';

-- Table: UBIGEO
CREATE TABLE UBIGEO (
    CODUBI char(6) NOT NULL COMMENT 'Contiene el identificador del ubigeo',
    DISUBI varchar(100) NOT NULL COMMENT 'Contiene el nombre del distrito',
    PROUBI varchar(100) NOT NULL COMMENT 'Contiene el nombre de la provincia',
    DEPUBI varchar(100) NOT NULL COMMENT 'Contiene el nombre del departamento',
    CONSTRAINT UBIGEO_pk PRIMARY KEY (CODUBI)
) COMMENT 'Contiene los ubigieos';

-- Table: UNIDAD
CREATE TABLE UNIDAD (
    CODUNI int NOT NULL AUTO_INCREMENT,
    DESUNI varchar(40) NOT NULL COMMENT 'Contiene la descripción de la unidad',
    CONSTRAINT UNIDAD_pk PRIMARY KEY (CODUNI)
) COMMENT 'Contiene las unidades de medida de los productos ';

-- Table: VENTAS
CREATE TABLE VENTAS (
    CODVENT char(5) NOT NULL COMMENT 'Contiene el identificar de las ventas',
    TIPVENT char(1) NOT NULL COMMENT 'B = BOLETA
F = FACTURA',
    FECVENT date NOT NULL COMMENT 'Contiene la fecha de la venta',
    EMPLEADO_CODPER int NOT NULL,
    PERSONA_CODPER int NOT NULL COMMENT 'Contiene el codigo de la persona',
    CAJAVENT varchar(2) NOT NULL COMMENT 'Contiene el numero de caja',
    EMPRESA_CODEMP int NOT NULL COMMENT 'Contiene el codigo de la empresa',
    CONSTRAINT VENTAS_pk PRIMARY KEY (CODVENT)
);

-- Table: VENTAS_DETALLE
CREATE TABLE VENTAS_DETALLE (
    CODVENTDET int NOT NULL AUTO_INCREMENT COMMENT 'Contiene el identificador de los detalles de ventas',
    CODVENT char(5) NOT NULL COMMENT 'Contiene el codigo de la venta',
    CANDETVENT int NOT NULL COMMENT 'Contiene la cantidad de producto a comprar',
    CODPRO char(4) NOT NULL COMMENT 'Contiene el codigo del producto',
    CONSTRAINT VENTAS_DETALLE_pk PRIMARY KEY (CODVENTDET)
);

-- foreign keys
-- Reference: CATEGORIA_PRODUCTO_CODCAT (table: PRODUCTO)
ALTER TABLE PRODUCTO ADD CONSTRAINT CATEGORIA_PRODUCTO_CODCAT FOREIGN KEY CATEGORIA_PRODUCTO_CODCAT (CODCAT)
    REFERENCES CATEGORIA (CODCAT);

-- Reference: EMPLEADO_VENTAS_CODPER (table: VENTAS)
ALTER TABLE VENTAS ADD CONSTRAINT EMPLEADO_VENTAS_CODPER FOREIGN KEY EMPLEADO_VENTAS_CODPER (EMPLEADO_CODPER)
    REFERENCES PERSONA (CODPER);

-- Reference: EMPRESA_UBIGEO (table: EMPRESA)
ALTER TABLE EMPRESA ADD CONSTRAINT EMPRESA_UBIGEO FOREIGN KEY EMPRESA_UBIGEO (UBIGEO_CODUBI)
    REFERENCES UBIGEO (CODUBI);

-- Reference: PERSONA_EMPRESA (table: PERSONA)
ALTER TABLE PERSONA ADD CONSTRAINT PERSONA_EMPRESA FOREIGN KEY PERSONA_EMPRESA (EMPRESA_CODEMP)
    REFERENCES EMPRESA (CODEMP);

-- Reference: PERSONA_VENTAS_CODPER (table: VENTAS)
ALTER TABLE VENTAS ADD CONSTRAINT PERSONA_VENTAS_CODPER FOREIGN KEY PERSONA_VENTAS_CODPER (PERSONA_CODPER)
    REFERENCES PERSONA (CODPER);

-- Reference: PRODUCTO_VENTAS_DETALLE_CODPRO (table: VENTAS_DETALLE)
ALTER TABLE VENTAS_DETALLE ADD CONSTRAINT PRODUCTO_VENTAS_DETALLE_CODPRO FOREIGN KEY PRODUCTO_VENTAS_DETALLE_CODPRO (CODPRO)
    REFERENCES PRODUCTO (CODPRO);

-- Reference: UBIGEO_PERSONA_CODUBI (table: PERSONA)
ALTER TABLE PERSONA ADD CONSTRAINT UBIGEO_PERSONA_CODUBI FOREIGN KEY UBIGEO_PERSONA_CODUBI (UBIPER)
    REFERENCES UBIGEO (CODUBI);

-- Reference: UNIDADES_PRODUCTO_CODUNI (table: PRODUCTO)
ALTER TABLE PRODUCTO ADD CONSTRAINT UNIDADES_PRODUCTO_CODUNI FOREIGN KEY UNIDADES_PRODUCTO_CODUNI (CODUNI)
    REFERENCES UNIDAD (CODUNI);

-- Reference: VENTAS_EMPRESA (table: VENTAS)
ALTER TABLE VENTAS ADD CONSTRAINT VENTAS_EMPRESA FOREIGN KEY VENTAS_EMPRESA (EMPRESA_CODEMP)
    REFERENCES EMPRESA (CODEMP);

-- Reference: VENTAS_VENTAS_DETALLE_CODVENT (table: VENTAS_DETALLE)
ALTER TABLE VENTAS_DETALLE ADD CONSTRAINT VENTAS_VENTAS_DETALLE_CODVENT FOREIGN KEY VENTAS_VENTAS_DETALLE_CODVENT (CODVENT)
    REFERENCES VENTAS (CODVENT);

-- End of file.

