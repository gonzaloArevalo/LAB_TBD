package com.tbd_grupo_8.lab_1.repositories;

import com.tbd_grupo_8.lab_1.entities.Categoria;
import com.tbd_grupo_8.lab_1.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class ProductoRepository {
    @Autowired
    private Sql2o sql2o;

    public List<Producto> findAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT id_producto, id_producto, nombre, descripcion, precio, stock," +
                            " estado, id_categoria FROM producto")
                    .executeAndFetch(Producto.class);
        }
    }
    public Producto findById(long id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT id_producto, nombre, descripcion, precio, stock, estado, " +
                            "id_categoria FROM producto WHERE id_producto = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Producto.class);
        }
    }
    public Producto save(Producto producto) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO producto (nombre, descripcion, precio, stock, estado, id_categoria)" +
                    " VALUES (:nombre, :descripcion, :precio, :stock, :estado, :id_categoria)";
            Long id = (Long) conn.createQuery(sql, true)
                    .addParameter("nombre", producto.getNombre())
                    .addParameter("descripcion", producto.getDescripcion())
                    .addParameter("precio", producto.getPrecio())
                    .addParameter("stock", producto.getStock())
                    .addParameter("estado", producto.getEstado())
                    .addParameter("id_categoria", producto.getId_categoria())
                    .executeUpdate()
                    .getKey();
            producto.setId_producto(id);
            return producto;
        }
    }
    public Producto update(Producto producto) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE producto SET nombre=:nombre, descripcion=:descripcion, precio=:precio, " +
                    "stock=:stock, estado=:estado, id_categoria=:id_categoria WHERE id_producto = :id_producto";
            conn.createQuery(sql, true)
                    .addParameter("nombre", producto.getNombre())
                    .addParameter("descripcion", producto.getDescripcion())
                    .addParameter("precio", producto.getPrecio())
                    .addParameter("stock", producto.getStock())
                    .addParameter("estado", producto.getEstado())
                    .addParameter("id_categoria", producto.getId_categoria())
                    .addParameter("id_producto", producto.getId_producto())
                    .executeUpdate();
            return producto;
        }
    }
    public boolean delete(long id) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM producto WHERE id_producto = :id";
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

}
