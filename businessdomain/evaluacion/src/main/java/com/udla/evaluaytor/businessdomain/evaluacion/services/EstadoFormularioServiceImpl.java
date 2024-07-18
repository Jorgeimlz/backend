package com.udla.evaluaytor.businessdomain.evaluacion.services;

import com.udla.evaluaytor.businessdomain.evaluacion.models.EstadoFormulario;
import com.udla.evaluaytor.businessdomain.evaluacion.repositories.EstadoFormularioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoFormularioServiceImpl implements EstadoFormularioService {

    @Autowired
    private EstadoFormularioRepository estadoFormularioRepository;

    @Override
    public List<EstadoFormulario> findAll() {
        return estadoFormularioRepository.findAll();
    }

    @Override
    public EstadoFormulario findById(Long id) {
        return estadoFormularioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Estado formulario no encontrado"));
    }

    @Override
    public EstadoFormulario save(EstadoFormulario estadoFormulario) {
        return estadoFormularioRepository.save(estadoFormulario);
    }

    @Override
    public EstadoFormulario updateById(Long id, EstadoFormulario estadoFormulario) {
        if (!estadoFormularioRepository.existsById(id)) {
            throw new RuntimeException("Estado formulario no encontrado");
        }
        estadoFormulario.setId(id);
        return estadoFormularioRepository.save(estadoFormulario);
    }

    @Override
    public void deleteById(Long id) {
        estadoFormularioRepository.deleteById(id);
    }
}
