-- Actualizar el stock a 0
UPDATE PRODUCTO SET stock = 0 WHERE id_producto = 1;

-- Verificar el cambio
SELECT id_producto, nombre, stock, estado FROM PRODUCTO WHERE id_producto = 1;

-- Actualizar el stock a un número positivo
UPDATE PRODUCTO SET stock = 5 WHERE id_producto = 1;

-- Verificar que volvió a 'Disponible'
SELECT id_producto, nombre, stock, estado FROM PRODUCTO WHERE id_producto = 1;