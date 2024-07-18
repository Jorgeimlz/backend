package com.udla.evaluaytor.businessdomain.evaluacion.services;

import com.udla.evaluaytor.businessdomain.evaluacion.models.FormularioEvaluacion;
import com.udla.evaluaytor.businessdomain.evaluacion.repositories.FormularioEvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormularioEvaluacionServiceImpl implements FormularioEvaluacionService {

    @Autowired
    private FormularioEvaluacionRepository formularioEvaluacionRepository;

    @Override
    public FormularioEvaluacion getFormularioEvaluacion(Long formularioId) {
        return formularioEvaluacionRepository.findById(formularioId)
            .orElseThrow(() -> new RuntimeException("Formulario no encontrado"));
    }

    @Override
    public List<FormularioEvaluacion> findAll() {
        return formularioEvaluacionRepository.findAll();
    }

    @Override
    public FormularioEvaluacion findById(Long id) {
        return formularioEvaluacionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Formulario no encontrado"));
    }

    @Override
    public FormularioEvaluacion save(FormularioEvaluacion formularioEvaluacion) {
        return formularioEvaluacionRepository.save(formularioEvaluacion);
    }

    @Override
    public FormularioEvaluacion updateById(Long id, FormularioEvaluacion formularioEvaluacion) {
        if (!formularioEvaluacionRepository.existsById(id)) {
            throw new RuntimeException("Formulario no encontrado");
        }
        formularioEvaluacion.setId(id);
        return formularioEvaluacionRepository.save(formularioEvaluacion);
    }

    @Override
    public void deleteById(Long id) {
        formularioEvaluacionRepository.deleteById(id);
    }
}
