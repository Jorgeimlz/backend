package com.udla.evaluaytor.businessdomain.evaluacion.services;

import com.udla.evaluaytor.businessdomain.evaluacion.models.FormularioEvaluacion;

import java.util.List;

public interface FormularioEvaluacionService {
    FormularioEvaluacion getFormularioEvaluacion(Long formularioId);
    List<FormularioEvaluacion> findAll();
    FormularioEvaluacion findById(Long id);
    FormularioEvaluacion save(FormularioEvaluacion formularioEvaluacion);
    FormularioEvaluacion updateById(Long id, FormularioEvaluacion formularioEvaluacion);
    void deleteById(Long id);
}
