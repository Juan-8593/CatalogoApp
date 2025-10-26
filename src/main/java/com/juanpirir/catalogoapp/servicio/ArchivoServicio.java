package com.juanpirir.catalogoapp.servicio;

import com.juanpirir.catalogoapp.entidad.ArchivoMultimedia;
import com.juanpirir.catalogoapp.entidad.TipoArchivo;
import com.juanpirir.catalogoapp.entidad.Titulo;
import com.juanpirir.catalogoapp.repositorio.ArchivoRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class ArchivoServicio {

    @Inject
    private ArchivoRepositorio repo;

    public void crear(ArchivoMultimedia archivo) {
        validarArchivo(archivo);
        repo.crear(archivo);
    }

    public ArchivoMultimedia actualizar(ArchivoMultimedia archivo) {
        validarArchivo(archivo);
        return repo.actualizar(archivo);
    }

    public void eliminar(Long id) {
        repo.eliminar(id);
    }

    public ArchivoMultimedia buscarPorId(Long id) {
        return repo.buscarPorId(id);
    }

    public List<ArchivoMultimedia> listarPorTitulo(Titulo titulo) {
        return repo.listarPorTitulo(titulo);
    }

    public long contarPorTipo(TipoArchivo tipo) {
        return repo.contarPorTipo(tipo);
    }

    public long contarTodos() {
        return repo.contarTodos();
    }

    // --- Reglas de negocio ---
    private void validarArchivo(ArchivoMultimedia a) {
        if (a.getTitulo() == null)
            throw new IllegalArgumentException("Debe asociar el archivo a un título.");
        if (a.getTipoArchivo() == null)
            throw new IllegalArgumentException("Debe especificar el tipo de archivo (PÓSTER o FICHA TÉCNICA).");
        if (a.getUrlBlob() == null || a.getUrlBlob().isBlank())
            throw new IllegalArgumentException("Debe proporcionar la URL del archivo.");
    }
}
