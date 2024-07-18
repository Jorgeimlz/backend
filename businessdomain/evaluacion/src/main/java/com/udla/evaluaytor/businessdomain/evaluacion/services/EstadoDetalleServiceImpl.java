package com.udla.evaluaytor.businessdomain.evaluacion.services;

import com.udla.evaluaytor.businessdomain.evaluacion.models.EstadoDetalle;
import com.udla.evaluaytor.businessdomain.evaluacion.repositories.EstadoDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoDetalleServiceImpl implements EstadoDetalleService {

    @Autowired
    private EstadoDetalleRepository estadoDetalleRepository;

    @Override
    public List<EstadoDetalle> findAll() {
        return estadoDetalleRepository.findAll();
    }

    @Override
    public EstadoDetalle findById(Long id) {
        return estadoDetalleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Estado detalle no encontrado"));
    }

    @Override
    public EstadoDetalle save(EstadoDetalle estadoDetalle) {
        return estadoDetalleRepository.save(estadoDetalle);
    }

    @Override
    public EstadoDetalle updateById(Long id, EstadoDetalle estadoDetalle) {
        if (!estadoDetalleRepository.existsById(id)) {
            throw new RuntimeException("Estado detalle no encontrado");
        }
        estadoDetalle.setId(id);
        return estadoDetalleRepository.save(estadoDetalle);
    }

    @Override
    public void deleteById(Long id) {
        estadoDetalleRepository.deleteById(id);
    }
}
