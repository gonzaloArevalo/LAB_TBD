package com.tbd_grupo_8.lab_1.repositories;

import com.tbd_grupo_8.lab_1.entities.DetalleOrden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class DetalleOrdenRepository {
    @Autowired
    private Sql2o sql2o;

    public List<DetalleOrden> findAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT id_detalle, id_orden, id_producto, cantidad, precio_unitario " +
                    "FROM detalle_orden")
                    .executeAndFetch(DetalleOrden.class);
        }
    }

    public DetalleOrden findById(long id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT id_detalle, id_orden, id_producto, cantidad, precio_unitario " +
                    "FROM detalle_orden WHERE id_detalle = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(DetalleOrden.class);
        }
    }

    public DetalleOrden findByOrdenId(long id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT id_detalle, id_orden, id_producto, cantidad, precio_unitario " +
                            "FROM detalle_orden WHERE id_orden = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(DetalleOrden.class);
        }
    }

    public DetalleOrden save(DetalleOrden detalleOrden) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO detalle_orden (id_orden, id_producto, cantidad, precio_unitario) VALUES " +
                    "(:id_orden, :id_producto, :cantidad, :precioUnitario)";
            Long id = (Long) conn.createQuery(sql, true)
                    .addParameter("id_orden", detalleOrden.getId_orden())
                    .addParameter("id_producto", detalleOrden.getId_producto())
                    .addParameter("cantidad", detalleOrden.getCantidad())
                    .addParameter("precioUnitario", detalleOrden.getPrecio_unitario())
                    .executeUpdate()
                    .getKey();
            detalleOrden.setId_detalle(id);
            return detalleOrden;
        }
    }

    public DetalleOrden update(DetalleOrden detalleOrden) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE detalle_orden SET " +
                    "id_orden = :id_orden," +
                    "id_producto = :id_producto," +
                    "cantidad = :cantidad," +
                    "id_orden = :id_orden," +
                    "precio_unitario = :precioUnitario" +
                    " WHERE id_detalle = :id_detalle";
            conn.createQuery(sql, true)
                    .addParameter("id_orden", detalleOrden.getId_orden())
                    .addParameter("id_producto", detalleOrden.getId_producto())
                    .addParameter("cantidad", detalleOrden.getCantidad())
                    .addParameter("precioUnitario", detalleOrden.getPrecio_unitario())
                    .executeUpdate();
            return detalleOrden;

        }
    }

    public boolean delete(Long id) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM detalle_orden WHERE id_orden = :id_orden";
            conn.createQuery(sql)
                    .addParameter("id_orden", id)
                    .executeUpdate();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
