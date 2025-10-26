package com.juanpirir.catalogoapp.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "titulo")
public class Titulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_titulo", nullable = false, length = 20)
    private TipoTitulo tipoTitulo;

    @Column(name = "anio_lanzamiento")
    private Integer anioLanzamiento;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public TipoTitulo getTipoTitulo() { return tipoTitulo; }
    public void setTipoTitulo(TipoTitulo tipoTitulo) { this.tipoTitulo = tipoTitulo; }

    public Integer getAnioLanzamiento() { return anioLanzamiento; }
    public void setAnioLanzamiento(Integer anioLanzamiento) { this.anioLanzamiento = anioLanzamiento; }
}
