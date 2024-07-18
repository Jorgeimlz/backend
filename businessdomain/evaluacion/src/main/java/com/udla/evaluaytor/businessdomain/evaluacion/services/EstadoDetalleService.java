package com.udla.evaluaytor.businessdomain.evaluacion.services;

import com.udla.evaluaytor.businessdomain.evaluacion.models.EstadoDetalle;

import java.util.List;

public interface EstadoDetalleService {
    List<EstadoDetalle> findAll();
    EstadoDetalle findById(Long id);
    EstadoDetalle save(EstadoDetalle estadoDetalle);
    EstadoDetalle updateById(Long id, EstadoDetalle estadoDetalle);
    void deleteById(Long id);
}
