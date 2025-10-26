package com.juanpirir.catalogoapp.web;

import com.juanpirir.catalogoapp.entidad.Titulo;
import com.juanpirir.catalogoapp.entidad.TipoTitulo;
import com.juanpirir.catalogoapp.servicio.TituloServicio;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named("TituloBean")
@SessionScoped
public class TituloBean implements Serializable {

    @Inject
    private TituloServicio servicio;

    private List<Titulo> lista;
    private Titulo titulo;
    private List<TipoTitulo> tipos;

    @PostConstruct
    public void init() {
        tipos = Arrays.asList(TipoTitulo.values());
        listar();
    }

    public void nuevo() {
        titulo = new Titulo();
    }

    public void listar() {
        lista = servicio.listarTodos();
    }

    public void editar(Titulo t) {
        titulo = t;
    }

    public void guardar() {
        if (titulo.getId() == null) {
            servicio.crear(titulo);
        } else {
            servicio.actualizar(titulo);
        }
        listar();
    }

    public void eliminar(Long id) {
        servicio.eliminar(id);
        listar();
    }

    // Getters
    public List<Titulo> getLista() { return lista; }
    public Titulo getTitulo() { return titulo; }
    public List<TipoTitulo> getTipos() { return tipos; }
}
