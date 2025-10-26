package com.juanpirir.catalogoapp.web;

import com.juanpirir.catalogoapp.entidad.Genero;
import com.juanpirir.catalogoapp.servicio.GeneroServicio;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("GeneroBean")
@SessionScoped
public class GeneroBean implements Serializable {

    @Inject
    private GeneroServicio servicio;

    private List<Genero> lista;
    private String nombre;

    @PostConstruct
    public void init() {
        listar();
    }

    public void listar() {
        lista = servicio.listarTodos();
    }

    public void agregar() {
        if (nombre != null && !nombre.isBlank()) {
            Genero g = new Genero();
            g.setNombre(nombre.trim());
            servicio.crear(g);
            nombre = "";
            listar();
        }
    }

    public void eliminar(Long id) {
        servicio.eliminar(id);
        listar();
    }


    public List<Genero> getLista() {
        return lista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
