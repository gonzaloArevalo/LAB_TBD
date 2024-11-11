package com.tbd_grupo_8.lab_1.services;

import com.tbd_grupo_8.lab_1.entities.DetalleOrden;
import com.tbd_grupo_8.lab_1.repositories.DetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleOrdenService {
    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;

    public List<DetalleOrden> findAll() { return detalleOrdenRepository.findAll(); }
    public DetalleOrden findById(long id) { return detalleOrdenRepository.findById(id); }
    public DetalleOrden findByOrdenId(long id) { return detalleOrdenRepository.findByOrdenId(id); }
    public DetalleOrden save(DetalleOrden detalleOrden) { return detalleOrdenRepository.save(detalleOrden); }
    public DetalleOrden update(DetalleOrden detalleOrden) {
        DetalleOrden existsDetalleOrden = detalleOrdenRepository.findById(detalleOrden.getId_detalle());
        if (existsDetalleOrden != null) {
            return detalleOrdenRepository.save(detalleOrden);
        }
        return null;
    }
    public boolean delete(Long id) {
        DetalleOrden existsDetalleOrden = detalleOrdenRepository.findById(id);
        if (existsDetalleOrden != null) {
            return detalleOrdenRepository.delete(id);
        }
        return false;
    }
}
