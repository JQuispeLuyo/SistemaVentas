-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2019-03-01 01:46:26.758

-- tables
-- Table: CATEGORIA

drop database sistema_venta;
create database sistema_venta;
use sistema_venta;

CREATE TABLE CATEGORIA (
    CODCAT char(4) NOT NULL COMMENT 'Contiene el identificador de las categorias de los productos',
    DESCAT varchar(30) NOT NULL COMMENT 'Contiene el nombre de la categoria',
    CONSTRAINT CATEGORIA_pk PRIMARY KEY (CODCAT)
) COMMENT 'Contiene la categoria de los productos';

-- Table: PERSONA
CREATE TABLE PERSONA (
    CODPER int NOT NULL AUTO_INCREMENT COMMENT 'Contiene el identificador de las personas',
    NOMPER varchar(80) NOT NULL COMMENT 'Contiene el nombre de la persona, o la razón social de la empresa',
    APEPER varchar(80) NULL COMMENT 'Contiene el apellido de la persona o nombre de la empresa',
    RUCDNIPER varchar(11) NULL COMMENT 'Contiene el DNI o RUC  (Persona o Empresa)',
    FECNAC date NULL COMMENT 'Contiene la fecha de nacimiento de la persona',
    UBIPER char(6) NULL COMMENT 'Contiene el ubigeo (Persona, Empresa)',
    DIRPER varchar(30) NULL COMMENT 'Contiene las calles donde vive la persona',
    TELPER char(9) NULL COMMENT 'Contiene el numero de teléfono de los Usuarios',
    GENPER char(1) NULL COMMENT 'Contiene el genero cliente y usuario',
    USEPER varchar(30) NULL COMMENT 'Contiene el nombre de usuario del Usuario',
    CONPER varchar(100) NULL COMMENT 'Contiene la contraseña del Usuario',
    TIPPER char(1) NOT NULL COMMENT 'Contiene el tipo de persona (cliente o usuario)',
    ESTAPER char(1) NOT NULL COMMENT 'Contiene el estado de la persona
A = Activo
B = Inactivo',
    CONSTRAINT PERSONA_pk PRIMARY KEY (CODPER)
) COMMENT 'Contiene los datos de los Clientes, Trabajadores y Empresas';

-- Table: PRODUCTO
CREATE TABLE PRODUCTO (
    CODPRO char(4) NOT NULL COMMENT 'Contiene el identificador de los productos ',
    CODCAT char(4) NOT NULL COMMENT 'Contiene el codigo de categoria',
    DESPRO varchar(100) NULL COMMENT 'Contiene la descripción del producto',
    PREPRO decimal(10,2) NOT NULL COMMENT 'Contiene el precio de los productos',
    CODUNI int NOT NULL COMMENT 'Contiene el codigo de la unidades',
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
    CODUNI int NOT NULL AUTO_INCREMENT COMMENT 'Contiene el identificador del tipo de unidad de los productos',
    DESUNI varchar(40) NOT NULL COMMENT 'Contiene la descripción de la unidad',
    CONSTRAINT UNIDAD_pk PRIMARY KEY (CODUNI)
) COMMENT 'Contiene las unidades de medida de los productos ';

-- Table: VENTAS
CREATE TABLE VENTAS (
    CODVENT char(5) NOT NULL COMMENT 'Contiene el identificar de las ventas',
    TIPVENT char(1) NOT NULL COMMENT 'B = BOLETA
F = FACTURA',
    FECVENT date NOT NULL COMMENT 'Contiene la fecha de la venta',
    EMPLEADO_CODPER int NOT NULL COMMENT 'Contiene el código de empleado',
    PERSONA_CODPER int NOT NULL COMMENT 'Contiene el código de cliente',
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

-- Reference: VENTAS_VENTAS_DETALLE_CODVENT (table: VENTAS_DETALLE)
ALTER TABLE VENTAS_DETALLE ADD CONSTRAINT VENTAS_VENTAS_DETALLE_CODVENT FOREIGN KEY VENTAS_VENTAS_DETALLE_CODVENT (CODVENT)
    REFERENCES VENTAS (CODVENT);

-- End of file.

