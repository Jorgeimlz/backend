package com.udla.evaluaytor.businessdomain.evaluacion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.udla.evaluaytor.businessdomain.evaluacion.models.EstadoDetalle;
import com.udla.evaluaytor.businessdomain.evaluacion.services.EstadoDetalleService;

import java.util.List;

@RestController
@RequestMapping("/api/evaluacion/estadodetalle")
public class EstadoDetalleController {

    @Autowired
    private EstadoDetalleService estadoDetalleService;

    @GetMapping("/findall")
    public List<EstadoDetalle> findAll() {
        return estadoDetalleService.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public EstadoDetalle findById(@PathVariable Long id) {
        return estadoDetalleService.findById(id);
    }

    @PostMapping("/save")
    public EstadoDetalle save(@RequestBody EstadoDetalle estadoDetalle) {
        return estadoDetalleService.save(estadoDetalle);
    }

    @PutMapping("/updatebyid/{id}")
    public EstadoDetalle updateById(@PathVariable Long id, @RequestBody EstadoDetalle estadoDetalle) {
        return estadoDetalleService.updateById(id, estadoDetalle);
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deleteById(@PathVariable Long id) {
        estadoDetalleService.deleteById(id);
    }
}
