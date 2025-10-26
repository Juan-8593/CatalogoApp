package com.juanpirir.catalogoapp.web;

import com.juanpirir.catalogoapp.entidad.ArchivoMultimedia;
import com.juanpirir.catalogoapp.entidad.TipoArchivo;
import com.juanpirir.catalogoapp.entidad.Titulo;
import com.juanpirir.catalogoapp.servicio.ArchivoServicio;
import com.juanpirir.catalogoapp.servicio.TituloServicio;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("ArchivoBean")
@SessionScoped
public class ArchivoBean implements Serializable {

    @Inject
    private ArchivoServicio archivoServicio;

    @Inject
    private TituloServicio tituloServicio;

    private List<ArchivoMultimedia> lista;
    private ArchivoMultimedia archivo;
    private List<Titulo> titulosDisponibles;

    @PostConstruct
    public void init() {
        listar();
        titulosDisponibles = tituloServicio.listarTodos();
        archivo = new ArchivoMultimedia();
    }

    public void listar() {
        lista = archivoServicio.contarTodos() > 0 ? archivoServicio.listarPorTitulo(null) : List.of();
    }

    public void nuevo() {
        archivo = new ArchivoMultimedia();
    }

    public void guardar() {
        try {
            if (archivo.getId() == null) {
                archivoServicio.crear(archivo);
            } else {
                archivoServicio.actualizar(archivo);
            }
            listar();
            archivo = new ArchivoMultimedia();
        } catch (IllegalArgumentException e) {
            System.err.println("Error al guardar archivo: " + e.getMessage());
        }
    }

    public void eliminar(Long id) {
        archivoServicio.eliminar(id);
        listar();
    }


    public List<ArchivoMultimedia> getLista() {
        return lista;
    }

    public ArchivoMultimedia getArchivo() {
        return archivo;
    }

    public void setArchivo(ArchivoMultimedia archivo) {
        this.archivo = archivo;
    }

    public TipoArchivo[] getTipos() {
        return TipoArchivo.values();
    }

    public List<Titulo> getTitulosDisponibles() {
        return titulosDisponibles;
    }
}
