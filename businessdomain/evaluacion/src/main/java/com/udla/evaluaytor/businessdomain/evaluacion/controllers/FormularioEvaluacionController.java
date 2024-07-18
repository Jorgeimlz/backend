package com.udla.evaluaytor.businessdomain.evaluacion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.udla.evaluaytor.businessdomain.evaluacion.models.FormularioEvaluacion;
import com.udla.evaluaytor.businessdomain.evaluacion.services.FormularioEvaluacionService;

import java.util.List;

@RestController
@RequestMapping("/api/evaluacion")
public class FormularioEvaluacionController {

    @Autowired
    private FormularioEvaluacionService formularioEvaluacionService;

    @GetMapping("/formulario/{formularioId}")
    public FormularioEvaluacion getFormularioEvaluacion(@PathVariable Long formularioId) {
        return formularioEvaluacionService.getFormularioEvaluacion(formularioId);
    }

    @GetMapping("/findall")
    public List<FormularioEvaluacion> findAll() {
        return formularioEvaluacionService.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public FormularioEvaluacion findById(@PathVariable Long id) {
        return formularioEvaluacionService.findById(id);
    }

    @PostMapping("/save")
    public FormularioEvaluacion save(@RequestBody FormularioEvaluacion formularioEvaluacion) {
        return formularioEvaluacionService.save(formularioEvaluacion);
    }

    @PutMapping("/updatebyid/{id}")
    public FormularioEvaluacion updateById(@PathVariable Long id, @RequestBody FormularioEvaluacion formularioEvaluacion) {
        return formularioEvaluacionService.updateById(id, formularioEvaluacion);
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deleteById(@PathVariable Long id) {
        formularioEvaluacionService.deleteById(id);
    }
}
