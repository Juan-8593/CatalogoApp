package com.juanpirir.catalogoapp.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(
        name = "titulos_generos",
        uniqueConstraints = @UniqueConstraint(columnNames = {"titulo_id", "genero_id"})
)
public class TituloGenero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "titulo_id", nullable = false)
    private Titulo titulo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "genero_id", nullable = false)
    private Genero genero;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Titulo getTitulo() { return titulo; }
    public void setTitulo(Titulo titulo) { this.titulo = titulo; }

    public Genero getGenero() { return genero; }
    public void setGenero(Genero genero) { this.genero = genero; }
}
