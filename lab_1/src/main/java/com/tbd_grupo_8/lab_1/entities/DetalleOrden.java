package com.tbd_grupo_8.lab_1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleOrden {
    private long id_detalle;
    private long id_orden;
    private long id_producto;
    private Integer cantidad;
    private double precio_unitario;
}
