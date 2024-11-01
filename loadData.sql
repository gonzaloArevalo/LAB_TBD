insert into CATEGORIA (id_categoria, nombre)
values (1, 'Accesorios'),
       (2, 'Teclados & Mouses'),
       (3, 'Monitores'),
       (4, 'Computadores Armados'),
       (5, 'Notebooks');

insert into PRODUCTO (id_producto, nombre, descripcion, precio, stock, estado, id_categoria)
values (1, 'Mouse Silencioso RGB',
        'Mouse Silencioso RGB\nMarca: Generic\nModel: SMRGBCD001\nDescripción: Mouse inhalámbrico de botones silenciosos y luces RGB',
        5000, 12, 'Disponible', 2),
        (2, 'Teclado DELL',
        'Teclado inhalámbrico DELL\nMarca: DELL\nModel: KM632\nDescripción: Teclado inhalámbrico DELL distribución Latinoamericana con pad numérico',
        23000, 5, 'Disponible', 2);

-- Inserción de datos en la tabla CLIENTE sin caracteres especiales
INSERT INTO CLIENTE (nombre, direccion, email, contrasena, telefono) VALUES
('Carlos Mendoza', 'Calle 123, Ciudad A', 'carlos.mendoza@mail.com', 'contrasena123', '555-1234'),
('Lucia Fernandez', 'Av. Central 45, Ciudad B', 'lucia.fernandez@mail.com', 'lucia_pass', '555-5678'),
('Andres Castillo', 'Calle Los Robles 85, Ciudad C', 'andres.castillo@mail.com', 'password456', '555-8765'),
('Maria Lopez', 'Av. Los Alamos 10, Ciudad D', 'maria.lopez@mail.com', 'pass_maria', '555-4321'),
('Jorge Martinez', 'Calle Primavera 21, Ciudad E', 'jorge.martinez@mail.com', 'jorge_2021', '555-2468'),
('Ana Ruiz', 'Av. La Esperanza 99, Ciudad F', 'ana.ruiz@mail.com', 'ruiz_ana', '555-1357'),
('Pedro Gonzalez', 'Calle Las Palmas 7, Ciudad G', 'pedro.gonzalez@mail.com', 'pg_password', '555-9753'),
('Laura Gil', 'Calle San Juan 88, Ciudad H', 'laura.gil@mail.com', 'gil_laura', '555-3579'),
('Sofia Duarte', 'Av. Norte 66, Ciudad I', 'sofia.duarte@mail.com', 'sofia_pass', '555-9632'),
('Ramon Perez', 'Calle del Sol 41, Ciudad J', 'ramon.perez@mail.com', 'ramon2022', '555-4682'),
('Carmen Vazquez', 'Av. Oriente 23, Ciudad K', 'carmen.vazquez@mail.com', 'carmen_vaz', '555-7524'),
('Diego Sanchez', 'Calle Pino 12, Ciudad L', 'diego.sanchez@mail.com', 'ds_password', '555-6142'),
('Paula Reyes', 'Av. Libertad 14, Ciudad M', 'paula.reyes@mail.com', 'paula_123', '555-8237'),
('Alberto Morales', 'Calle Nueva 33, Ciudad N', 'alberto.morales@mail.com', 'am_password', '555-7481'),
('Marta Salinas', 'Av. Los Pinos 54, Ciudad O', 'marta.salinas@mail.com', 'salinas_marta', '555-2153'),
('Luis Rojas', 'Calle Cedros 98, Ciudad P', 'luis.rojas@mail.com', 'rojas_luis', '555-9425'),
('Gloria Vega', 'Av. Amanecer 60, Ciudad Q', 'gloria.vega@mail.com', 'vega_pass', '555-7893'),
('Tomas Rivera', 'Calle Luna 67, Ciudad R', 'tomas.rivera@mail.com', 'rivera_tomas', '555-1568'),
('Isabel Romero', 'Av. Principal 5, Ciudad S', 'isabel.romero@mail.com', 'romero_isabel', '555-8947'),
('Vicente Navarro', 'Calle Real 19, Ciudad T', 'vicente.navarro@mail.com', 'navarro_vicente', '555-3256');
