package com.juanpirir.catalogoapp.entidad;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ArchivoRepositorio {

    @PersistenceContext(unitName = "catalogoPU")
    private EntityManager em;

    public void crear(ArchivoMultimedia archivo) {
        em.persist(archivo);
    }

    public ArchivoMultimedia actualizar(ArchivoMultimedia archivo) {
        return em.merge(archivo);
    }

    public void eliminar(Long id) {
        ArchivoMultimedia a = em.find(ArchivoMultimedia.class, id);
        if (a != null) {
            em.remove(a);
        }
    }

    public ArchivoMultimedia buscarPorId(Long id) {
        return em.find(ArchivoMultimedia.class, id);
    }

    public List<ArchivoMultimedia> listarPorTitulo(Titulo titulo) {
        return em.createQuery("""
                SELECT a FROM ArchivoMultimedia a
                WHERE a.titulo = :titulo
                ORDER BY a.fechaSubida DESC
            """, ArchivoMultimedia.class)
                .setParameter("titulo", titulo)
                .getResultList();
    }

    public long contarPorTipo(TipoArchivo tipo) {
        return em.createQuery("""
                SELECT COUNT(a) FROM ArchivoMultimedia a
                WHERE a.tipoArchivo = :tipo
            """, Long.class)
                .setParameter("tipo", tipo)
                .getSingleResult();
    }

    public long contarTodos() {
        return em.createQuery("SELECT COUNT(a) FROM ArchivoMultimedia a", Long.class)
                .getSingleResult();
    }
}
