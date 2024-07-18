package com.udla.evaluaytor.businessdomain.empresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.udla.evaluaytor.businessdomain.empresa.dto.ProveedorDTO;
import com.udla.evaluaytor.businessdomain.empresa.dto.ProveedorResponseDTO;
import com.udla.evaluaytor.businessdomain.empresa.models.*;
import com.udla.evaluaytor.businessdomain.empresa.repositories.*;
import com.udla.evaluaytor.businessdomain.empresa.services.ProveedorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private PeritoRepository peritoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private MatrizEvaluacionRepository matrizEvaluacionRepository;

    // Proveedor Endpoints
    @PostMapping("/proveedor/save")
    public ResponseEntity<ProveedorResponseDTO> createProveedor(@RequestBody ProveedorDTO proveedorDTO) {
        ProveedorResponseDTO proveedorGuardado = proveedorService.createProveedor(proveedorDTO);
        return new ResponseEntity<>(proveedorGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/proveedor/update/{id}")
    public ResponseEntity<ProveedorResponseDTO> updateProveedor(@PathVariable Long id, @RequestBody ProveedorDTO proveedorUpdateDTO) {
        ProveedorResponseDTO updatedProveedor = proveedorService.updateProveedor(id, proveedorUpdateDTO);
        return ResponseEntity.ok(updatedProveedor);
    }

    @GetMapping("/proveedor/findall")
    public ResponseEntity<List<ProveedorResponseDTO>> getAllProveedores() {
        List<ProveedorResponseDTO> proveedores = proveedorService.getAllProveedores();
        return ResponseEntity.ok(proveedores);
    }

    @GetMapping("/proveedor/findbyid/{id}")
    public ResponseEntity<ProveedorResponseDTO> getProveedorById(@PathVariable Long id) {
        ProveedorResponseDTO proveedor = proveedorService.getProveedorById(id);
        return ResponseEntity.ok(proveedor);
    }

    @DeleteMapping("/proveedor/deletebyid/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Long id) {
        proveedorService.deleteProveedor(id);
        return ResponseEntity.noContent().build();
    }

    // Perito Endpoints
    @GetMapping("/perito/findall")
    public ResponseEntity<List<Perito>> getAllPeritos() {
        List<Perito> peritos = peritoRepository.findAll();
        return ResponseEntity.ok(peritos);
    }

    @GetMapping("/perito/findbyid/{id}")
    public ResponseEntity<Perito> getPeritoById(@PathVariable Long id) {
        Optional<Perito> peritoOptional = peritoRepository.findById(id);
        return peritoOptional.map(perito -> new ResponseEntity<>(perito, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/perito/save")
    public ResponseEntity<Perito> createPerito(@RequestBody Perito perito) {
        Perito peritoGuardado = peritoRepository.save(perito);
        return new ResponseEntity<>(peritoGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/perito/updatebyid/{id}")
    public ResponseEntity<Perito> updatePerito(@PathVariable Long id, @RequestBody Perito peritoUpdate) {
        Optional<Perito> optionalPerito = peritoRepository.findById(id);
        if (!optionalPerito.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Perito perito = optionalPerito.get();
        perito.setNombre(peritoUpdate.getNombre());
        perito.setDireccion(peritoUpdate.getDireccion());
        perito.setTelefono(peritoUpdate.getTelefono());
        peritoRepository.save(perito);
        return ResponseEntity.ok(perito);
    }

    @DeleteMapping("/perito/deletebyid/{id}")
    public ResponseEntity<Void> deletePerito(@PathVariable Long id) {
        peritoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Categoria Endpoints
    @GetMapping("/categoria/findall")
    public ResponseEntity<List<Categoria>> getAllCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/categoria/findbyid/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        return categoriaOptional.map(categoria -> new ResponseEntity<>(categoria, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/categoria/save")
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        Categoria categoriaGuardada = categoriaRepository.save(categoria);
        return new ResponseEntity<>(categoriaGuardada, HttpStatus.CREATED);
    }

    @PutMapping("/categoria/updatebyid/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @RequestBody Categoria categoriaUpdate) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        if (!optionalCategoria.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Categoria categoria = optionalCategoria.get();
        categoria.setDescripcion(categoriaUpdate.getDescripcion());
        categoriaRepository.save(categoria);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/categoria/deletebyid/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        categoriaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Matriz Evaluacion Endpoints
    @GetMapping("/matrizevaluacion/findall")
    public ResponseEntity<List<MatrizEvaluacion>> getAllMatrizEvaluacion() {
        List<MatrizEvaluacion> matrizEvaluacion = matrizEvaluacionRepository.findAll();
        return ResponseEntity.ok(matrizEvaluacion);
    }

    @GetMapping("/matrizevaluacion/findbyid/{id}")
    public ResponseEntity<MatrizEvaluacion> getMatrizEvaluacionById(@PathVariable Long id) {
        Optional<MatrizEvaluacion> matrizEvaluacionOptional = matrizEvaluacionRepository.findById(id);
        return matrizEvaluacionOptional.map(matrizEvaluacion -> new ResponseEntity<>(matrizEvaluacion, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/matrizevaluacion/save")
    public ResponseEntity<MatrizEvaluacion> createMatrizEvaluacion(@RequestBody MatrizEvaluacion matrizEvaluacion) {
        MatrizEvaluacion matrizEvaluacionGuardada = matrizEvaluacionRepository.save(matrizEvaluacion);
        return new ResponseEntity<>(matrizEvaluacionGuardada, HttpStatus.CREATED);
    }

    @PutMapping("/matrizevaluacion/updatebyid/{id}")
    public ResponseEntity<MatrizEvaluacion> updateMatrizEvaluacion(@PathVariable Long id, @RequestBody MatrizEvaluacion matrizEvaluacionUpdate) {
        Optional<MatrizEvaluacion> optionalMatrizEvaluacion = matrizEvaluacionRepository.findById(id);
        if (!optionalMatrizEvaluacion.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        MatrizEvaluacion matrizEvaluacion = optionalMatrizEvaluacion.get();
        matrizEvaluacion.setPregunta(matrizEvaluacionUpdate.getPregunta());
        matrizEvaluacion.setPuntos(matrizEvaluacionUpdate.getPuntos());
        matrizEvaluacion.setRequiereDocumento(matrizEvaluacionUpdate.isRequiereDocumento());
        matrizEvaluacion.setCategoria(matrizEvaluacionUpdate.getCategoria());
        matrizEvaluacionRepository.save(matrizEvaluacion);
        return ResponseEntity.ok(matrizEvaluacion);
    }

    @DeleteMapping("/matrizevaluacion/deletebyid/{id}")
    public ResponseEntity<Void> deleteMatrizEvaluacion(@PathVariable Long id) {
        matrizEvaluacionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
