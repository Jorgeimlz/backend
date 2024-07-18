package com.udla.evaluaytor.businessdomain.evaluacion.services;

import com.udla.evaluaytor.businessdomain.evaluacion.models.EstadoFormulario;

import java.util.List;

public interface EstadoFormularioService {
    List<EstadoFormulario> findAll();
    EstadoFormulario findById(Long id);
    EstadoFormulario save(EstadoFormulario estadoFormulario);
    EstadoFormulario updateById(Long id, EstadoFormulario estadoFormulario);
    void deleteById(Long id);
}
