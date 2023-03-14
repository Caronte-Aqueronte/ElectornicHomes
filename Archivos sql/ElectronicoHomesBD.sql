CREATE DATABASE electronichomes;

\c electronichomes

CREATE SCHEMA RegistroRecursos;
CREATE SCHEMA RegistroVentas;  
CREATE SCHEMA RegistroPersonal;

--TABLAS PARA EL REGISTRO D EPERSONAL
CREATE TABLE RegistroPersonal.Sucursal(
    nombre VARCHAR(50) NOT NULL,
    PRIMARY KEY (nombre)
);

CREATE TABLE RegistroPersonal.Empleado(
    id_empleado SERIAL NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    edad INT NOT NULL,
    sucursal VARCHAR(50) NOT NULL,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    contra VARCHAR(50) NOT NULL,
    rol VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_empleado),
    FOREIGN KEY (sucursal) REFERENCES RegistroPersonal.Sucursal(nombre) ON DELETE CASCADE ON UPDATE CASCADE 
);

--TABLAS PARA EL REGISTRO DE LOS RECURSOS
CREATE TABLE RegistroRecursos.Producto(
    nombre VARCHAR(50) NOT NULL,
    descripcion TEXT NOT NULL,
    precio_compra DECIMAL (10,2) NOT NULL,
    precio_venta DECIMAL (10,2) NOT NULL,
    PRIMARY KEY (nombre)
);

CREATE TABLE RegistroRecursos.Compra(
    codigo_barras INT NOT NULL,
    fecha_compra DATE NOT NULL,
    producto VARCHAR(50) NOT NULL,
    PRIMARY KEY (codigo_barras),
    FOREIGN KEY (producto) REFERENCES RegistroRecursos.Producto(nombre) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE RegistroRecursos.Bodega(
    compra INT NOT NULL,
    PRIMARY KEY (compra),
    FOREIGN KEY (compra) REFERENCES RegistroRecursos.Compra(codigo_barras) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE RegistroRecursos.Inventario(
    compra INT NOT NULL,
    sucursal VARCHAR(50) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    PRIMARY KEY (compra),
    FOREIGN KEY (sucursal) REFERENCES RegistroPersonal.Sucursal(nombre) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (compra) REFERENCES RegistroRecursos.Compra(codigo_barras) ON DELETE CASCADE ON UPDATE CASCADE
);

--TABLAS PARA EL REGISTRO DE VENTAS
CREATE TABLE RegistroVentas.Cliente(
    nit BIGINT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    telefono BIGINT NOT NULL,
    PRIMARY KEY (nit)
);

CREATE TABLE RegistroVentas.Venta(
    id_venta VARCHAR(50) NOT NULL,
    sucursal VARCHAR(50) NOT NULL,
    empleado INT NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    descuento DECIMAL(10,2) NOT NULL,
    importe_venta DECIMAL(10,2) NOT NULL,
    fecha DATE NOT NULL,
    PRIMARY KEY (id_venta),
    FOREIGN KEY (sucursal) REFERENCES RegistroPersonal.Sucursal(nombre) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (empleado) REFERENCES RegistroPersonal.Empleado(id_empleado) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE RegistroVentas.Adquisicion(
    venta VARCHAR(50) NOT NULL,
    cliente BIGINT NOT NULL,
    PRIMARY KEY (venta),
    FOREIGN KEY (venta) REFERENCES RegistroVentas.Venta(id_venta) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (cliente) REFERENCES RegistroVentas.Cliente(nit) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE RegistroVentas.Desgloce(
    venta VARCHAR(50) NOT NULL,
    inventario INT NOT NULL,
    total DECIMAL(10,2),
    PRIMARY KEY (inventario),
    FOREIGN KEY (venta) REFERENCES RegistroVentas.Venta(id_venta) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (inventario) REFERENCES RegistroRecursos.Inventario(compra) ON DELETE CASCADE ON UPDATE CASCADE
);

