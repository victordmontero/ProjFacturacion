USE master;
GO
CREATE DATABASE ProjFacturacion;
GO
USE ProjFacturacion;

CREATE TABLE Clientes(
    ClienteId INT PRIMARY KEY IDENTITY(1,1),
    Nombre VARCHAR(50) NOT NULL,
    RNC CHAR(11) NOT NULL,
    Direccion VARCHAR(50),
    Telefono CHAR(13),
    Email VARCHAR(100)
);
 
CREATE TABLE Productos(
    ProductoId INT PRIMARY KEY IDENTITY(1,1),
    Descripcion VARCHAR(50) NOT NULL,
    Precio DECIMAL(16,2) NOT NULL,
    Exento DECIMAL(16,2) NOT NULL
);

CREATE TABLE Facturas(
    FacturaId INT PRIMARY KEY IDENTITY(1,1),
    ClienteId INT,
    NCF CHAR(19) NOT NULL,
    Fecha DATE
);

CREATE TABLE FacturaDetalle
(
    ProductoId INT,
    FacturaId INT,
    Precio DECIMAL(16,2),
    Cantidad INT,
    PRIMARY KEY(ProductoId,FacturaId)
);

ALTER TABLE Facturas
ADD FOREIGN KEY (ClienteId)
REFERENCES Clientes(ClienteId);

ALTER TABLE FacturaDetalle
ADD FOREIGN KEY (ProductoId)
REFERENCES Productos(ProductoId);

ALTER TABLE FacturaDetalle
ADD FOREIGN KEY (FacturaId)
REFERENCES Facturas(FacturaId);

CREATE UNIQUE INDEX IX_Clientes_RNC ON Clientes(RNC);
CREATE UNIQUE INDEX IX_Facturas_NCF ON Facturas(NCF);
