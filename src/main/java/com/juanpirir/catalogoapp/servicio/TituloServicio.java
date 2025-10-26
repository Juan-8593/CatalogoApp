package com.juanpirir.catalogoapp.servicio;

import com.juanpirir.catalogoapp.entidad.Titulo;
import com.juanpirir.catalogoapp.entidad.TipoTitulo;
import com.juanpirir.catalogoapp.repositorio.TituloRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.time.Year;
import java.util.List;

@ApplicationScoped
@Transactional
public class TituloServicio {

    @Inject
    private TituloRepositorio repo;

    public void crear(Titulo titulo) {
        validarTitulo(titulo);
        repo.crear(titulo);
    }

    public Titulo actualizar(Titulo titulo) {
        validarTitulo(titulo);
        return repo.actualizar(titulo);
    }

    public void eliminar(Long id) {
        repo.eliminar(id);
    }

    public Titulo buscarPorId(Long id) {
        return repo.buscarPorId(id);
    }

    public List<Titulo> listarTodos() {
        return repo.listarTodos();
    }

    public List<Titulo> buscarPorTipo(TipoTitulo tipo) {
        return repo.buscarPorTipo(tipo);
    }

    public long contarTodos() {
        return repo.contarTodos();
    }

    public long contarPorTipo(TipoTitulo tipo) {
        return repo.contarPorTipo(tipo);
    }

    public long contarConPoster() {
        return repo.contarConPoster();
    }

    // --- Reglas de negocio ---
    private void validarTitulo(Titulo t) {
        if (t.getNombre() == null || t.getNombre().isBlank()) {
            throw new IllegalArgumentException("El título debe tener un nombre.");
        }
        if (t.getTipoTitulo() == null) {
            throw new IllegalArgumentException("Debe seleccionar el tipo de título (PELÍCULA o SERIE).");
        }
        if (t.getAnioLanzamiento() == null) {
            throw new IllegalArgumentException("Debe indicar el año de lanzamiento.");
        }
        int actual = Year.now().getValue();
        if (t.getAnioLanzamiento() > actual) {
            throw new IllegalArgumentException("El año de lanzamiento no puede ser mayor al actual.");
        }
    }
}
