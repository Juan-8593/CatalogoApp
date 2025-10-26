package com.juanpirir.catalogoapp.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "generos")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "nombre", unique = true, length = 50, nullable = false)
    private String nombre;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
