package com.juanpirir.catalogoapp.servicio;

import com.juanpirir.catalogoapp.entidad.Genero;
import com.juanpirir.catalogoapp.repositorio.GeneroRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class GeneroServicio {

    @Inject
    private GeneroRepositorio repo;

    public void crear(Genero genero) {
        validarGenero(genero);
        repo.crear(genero);
    }

    public Genero actualizar(Genero genero) {
        validarGenero(genero);
        return repo.actualizar(genero);
    }

    public void eliminar(Long id) {
        repo.eliminar(id);
    }

    public Genero buscarPorId(Long id) {
        return repo.buscarPorId(id);
    }

    public List<Genero> listarTodos() {
        return repo.listarTodos();
    }

    public long contarTodos() {
        return repo.contarTodos();
    }

    // --- Regla de negocio ---
    private void validarGenero(Genero g) {
        if (g.getNombre() == null || g.getNombre().isBlank()) {
            throw new IllegalArgumentException("El género debe tener un nombre.");
        }
    }
}
