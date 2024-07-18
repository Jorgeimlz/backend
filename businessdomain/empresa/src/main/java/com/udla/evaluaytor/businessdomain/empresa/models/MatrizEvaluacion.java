package com.udla.evaluaytor.businessdomain.empresa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class MatrizEvaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pregunta;
    private int puntos;
    private boolean requiereDocumento;

    @ManyToOne
    @JoinColumn(name = "id_categoria")  // Cambiado a id_categoria para coincidir con el nombre en la base de datos
    private Categoria categoria;
}
