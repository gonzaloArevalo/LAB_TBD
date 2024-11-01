

-- Eliminar la base de datos si ya existe
DROP DATABASE IF EXISTS tbd_lab_1;

-- Crear la base de datos
CREATE DATABASE tbd_lab_1;

-- Conectarse a la nueva base de datos
\c tbd_lab_1

-- Inicio de la creación de tablas
BEGIN;

CREATE TABLE IF NOT EXISTS CLIENTE
(
    id_cliente serial NOT NULL PRIMARY KEY,
    nombre varchar(255),
    direccion varchar(255),
    email varchar(100),
    contrasena varchar(100),
    telefono varchar(20)
);

END;