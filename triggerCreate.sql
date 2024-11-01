-- Primero creamos la función que ejecutará el trigger
CREATE OR REPLACE FUNCTION actualizar_estado_producto()
RETURNS TRIGGER AS $$
BEGIN
    -- Si el nuevo stock es 0, actualizamos el estado a 'Agotado'
    IF NEW.stock = 0 THEN
        NEW.estado = 'Agotado';
    -- Si el stock vuelve a ser mayor que 0, actualizamos el estado a 'Disponible'
    ELSIF NEW.stock > 0 AND OLD.estado = 'Agotado' THEN
        NEW.estado = 'Disponible';
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Luego creamos el trigger
CREATE TRIGGER trigger_actualizar_estado_producto
    BEFORE UPDATE OF stock
    ON PRODUCTO
    FOR EACH ROW
    EXECUTE FUNCTION actualizar_estado_producto();