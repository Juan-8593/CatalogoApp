package com.juanpirir.catalogoapp.servicio;

import com.juanpirir.catalogoapp.entidad.TipoArchivo;
import com.juanpirir.catalogoapp.entidad.TipoTitulo;
import com.juanpirir.catalogoapp.repositorio.TituloRepositorio;
import com.juanpirir.catalogoapp.repositorio.ArchivoRepositorio;
import com.juanpirir.catalogoapp.repositorio.GeneroRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ConsultasServicio {

    @Inject
    private TituloRepositorio tituloRepo;

    @Inject
    private ArchivoRepositorio archivoRepo;

    @Inject
    private GeneroRepositorio generoRepo;

    public long totalTitulos() {
        return tituloRepo.contarTodos();
    }

    public long totalPeliculas() {
        return tituloRepo.contarPorTipo(TipoTitulo.PELICULA);
    }

    public long totalSeries() {
        return tituloRepo.contarPorTipo(TipoTitulo.SERIE);
    }

    public long totalGeneros() {
        return generoRepo.contarTodos();
    }

    public long totalArchivos() {
        return archivoRepo.contarTodos();
    }

    public long titulosConPoster() {
        return tituloRepo.contarConPoster();
    }

    public long totalPosters() {
        return archivoRepo.contarPorTipo(TipoArchivo.POSTER);
    }

    public long totalFichasTecnicas() {
        return archivoRepo.contarPorTipo(TipoArchivo.FICHA_TECNICA);
    }
}
