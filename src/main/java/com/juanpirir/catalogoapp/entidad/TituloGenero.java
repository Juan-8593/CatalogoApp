package com.juanpirir.catalogoapp.entidad;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(
        name = "titulos_generos",
        uniqueConstraints = @UniqueConstraint(columnNames = {"titulo_id", "genero_id"})
)
public class TituloGenero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "titulo_id", nullable = false)
    private Titulo titulo;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "genero_id", nullable = false)
    private Genero genero;

    public TituloGenero() {}

    public TituloGenero(Titulo titulo, Genero genero) {
        this.titulo = titulo;
        this.genero = genero;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Titulo getTitulo() { return titulo; }
    public void setTitulo(Titulo titulo) { this.titulo = titulo; }

    public Genero getGenero() { return genero; }
    public void setGenero(Genero genero) { this.genero = genero; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TituloGenero)) return false;
        TituloGenero that = (TituloGenero) o;
        return Objects.equals(titulo, that.titulo) &&
                Objects.equals(genero, that.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, genero);
    }

    @Override
    public String toString() {
        return "{" + titulo.getNombre() + " - " + genero.getNombre() + "}";
    }
}
