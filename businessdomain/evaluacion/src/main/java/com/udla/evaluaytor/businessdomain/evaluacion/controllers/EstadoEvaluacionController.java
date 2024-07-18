package com.udla.evaluaytor.businessdomain.evaluacion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.udla.evaluaytor.businessdomain.evaluacion.models.EstadoFormulario;
import com.udla.evaluaytor.businessdomain.evaluacion.services.EstadoFormularioService;

import java.util.List;

@RestController
@RequestMapping("/api/evaluacion/estadoevaluacion")
public class EstadoEvaluacionController {

    @Autowired
    private EstadoFormularioService estadoFormularioService;

    @GetMapping("/findall")
    public List<EstadoFormulario> findAll() {
        return estadoFormularioService.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public EstadoFormulario findById(@PathVariable Long id) {
        return estadoFormularioService.findById(id);
    }

    @PostMapping("/save")
    public EstadoFormulario save(@RequestBody EstadoFormulario estadoFormulario) {
        return estadoFormularioService.save(estadoFormulario);
    }

    @PutMapping("/updatebyid/{id}")
    public EstadoFormulario updateById(@PathVariable Long id, @RequestBody EstadoFormulario estadoFormulario) {
        return estadoFormularioService.updateById(id, estadoFormulario);
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deleteById(@PathVariable Long id) {
        estadoFormularioService.deleteById(id);
    }
}
