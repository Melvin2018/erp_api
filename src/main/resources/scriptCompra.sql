drop database if exists compra;
create database compra;
use compra;
CREATE table empresa (
  id bigint primary key AUTO_INCREMENT,
  nombre VARCHAR(100) not null,
  telefono VARCHAR(45),
  direccion text
  );
CREATE TABLE sucursal (
 id bigint primary key AUTO_INCREMENT,
  nombre VARCHAR(100)NOT NULL,
  telefono VARCHAR(45) NOT NULL,
  direccion text,
  encargado bigint not null,
  empresa bigint NOT NULL,
  CONSTRAINT fk_sucursal_empresa foreign KEY (empresa) REFERENCES empresa(id)
);
CREATE TABLE inventario(
 id bigint primary key AUTO_INCREMENT,
  sucursal bigint not null,
  tipoinventario int,
   constraint fk_inventario_sucursal foreign KEY (sucursal) REFERENCES sucursal(id)
  );
CREATE TABLE marca(
  id bigint primary key AUTO_INCREMENT,
  nombre VARCHAR(100) not null
);
  
CREATE TABLE categoria (
  id bigint primary key AUTO_INCREMENT,
  nombre VARCHAR(100) not NULL,
  margen DECIMAL(10,2)not NULL
);

CREATE TABLE proveedor (
 id bigint primary key AUTO_INCREMENT,
  nombre VARCHAR(100)not NULL,
  nombrecomercial VARCHAR(45)not NULL,
  nit VARCHAR(45)not NULL,
  nrc VARCHAR(45)not NULL,
  contacto VARCHAR(45)not NULL,
  telefono VARCHAR(45)not NULL,
  giro VARCHAR(45),
  email VARCHAR(45),
  direccion VARCHAR(45)
  );
CREATE TABLE Producto (
  id bigint primary key AUTO_INCREMENT,
  nombre VARCHAR(45)not NULL,
  imagen text,
  margen DECIMAL(10,2)not NULL,
  codigointerno text NULL,
  codigobarras text NULL,
  marca bigint not NULL,
  categoria bigint not NULL,
  proveedor bigint not NULL,
  CONSTRAINT fk_producto_marca FOREIGN KEY (marca) REFERENCES marca (id),
  CONSTRAINT fk_producto_categoria FOREIGN KEY (categoria) REFERENCES categoria (id),
  CONSTRAINT fk_producto_proveedor FOREIGN KEY (proveedor) REFERENCES proveedor (id)
   );
CREATE TABLE detalleinventario (
 id bigint primary key AUTO_INCREMENT,
  producto bigint not null,
  costo DECIMAL(10,2) not null,
  margen DECIMAL(10,2) not null,
  existencia INT not null,
  stockmin INT not null,
  stockmax INT not null,
  inventario bigint not null,
  CONSTRAINT fk_detalleinventario_producto FOREIGN KEY (producto)  REFERENCES producto (id),
  CONSTRAINT fk_detalleinventario_inventario FOREIGN KEY (inventario) REFERENCES inventario (id)
  );
  CREATE TABLE empleado (
 id bigint primary key AUTO_INCREMENT,
  nombre VARCHAR(100) not null,
  email VARCHAR(45) NULL,
  telefono VARCHAR(45) not null,
  direccion text not null,
  sucursal bigint not null,
  CONSTRAINT fk_empleado_sucursal FOREIGN KEY (sucursal) REFERENCES sucursal (id)
);
CREATE TABLE usuario (
  id bigint primary key AUTO_INCREMENT,
  username VARCHAR(45) not null,
  password text not null,
  id_empleado bigint NOT NULL,
  CONSTRAINT fk_usuario_empleado FOREIGN KEY (id_empleado) REFERENCES empleado (id)
 );
CREATE TABLE compra (
 id bigint primary key AUTO_INCREMENT,
  fecha datetime not null,
  usuario bigint not null,
  costomanejo DECIMAL(10,2) not null,
  factura VARCHAR(45) not null,
  CONSTRAINT fk_compra_usuario FOREIGN KEY (usuario) REFERENCES usuario (id)
  );
CREATE TABLE ordencompra (
  id bigint primary key AUTO_INCREMENT,
  fecha datetime not null,
  compra bigint not null,
  proveedor bigint not null,
  estado INT not null,
  CONSTRAINT fk_ordencompra_usuario FOREIGN KEY (compra) REFERENCES compra(id),
  CONSTRAINT fk_ordencompra_proveedor FOREIGN KEY (proveedor)  REFERENCES proveedor (id)
  );
CREATE TABLE detalleordencompra (
  id bigint primary key AUTO_INCREMENT,
  producto bigint not null,
  costo DECIMAL(10,2) not null,
  cantidad INT not null,
  ordencompra bigint not null,
  CONSTRAINT fk_ordencompra_producto FOREIGN KEY (producto)  REFERENCES producto (id),
  CONSTRAINT fk_ordencompra_ordencompra FOREIGN KEY (ordencompra) REFERENCES ordencompra (id)
 );

CREATE TABLE rol (
 id bigint primary key AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL
  );
CREATE TABLE Rolesusuarios (
id bigint primary key AUTO_INCREMENT,
usuario bigint NOT NULL,
rol bigint NOT NULL,
CONSTRAINT fk_rolesusuario_rol FOREIGN KEY (rol) REFERENCES rol (id),
CONSTRAINT fk_rolesusuario_usuario FOREIGN KEY (usuario) REFERENCES usuario (id)
);
 alter table sucursal add constraint fk_sucursal_usuario foreign KEY (encargado) REFERENCES usuario(id);
