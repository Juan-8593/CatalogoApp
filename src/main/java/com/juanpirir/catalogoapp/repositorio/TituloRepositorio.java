package com.juanpirir.catalogoapp.repositorio;

import com.juanpirir.catalogoapp.entidad.Titulo;
import com.juanpirir.catalogoapp.entidad.TipoTitulo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class TituloRepositorio {

    @PersistenceContext(unitName = "catalogoPU")
    private EntityManager em;

    public void crear(Titulo titulo) {
        em.persist(titulo);
    }

    public Titulo actualizar(Titulo titulo) {
        return em.merge(titulo);
    }

    public void eliminar(Long id) {
        Titulo t = em.find(Titulo.class, id);
        if (t != null) {
            em.remove(t);
        }
    }

    public Titulo buscarPorId(Long id) {
        return em.find(Titulo.class, id);
    }

    public List<Titulo> listarTodos() {
        return em.createQuery("SELECT t FROM Titulo t ORDER BY t.nombre", Titulo.class)
                .getResultList();
    }

    public List<Titulo> buscarPorTipo(TipoTitulo tipo) {
        return em.createQuery("SELECT t FROM Titulo t WHERE t.tipo = :tipo ORDER BY t.nombre", Titulo.class)
                .setParameter("tipo", tipo)
                .getResultList();
    }

    public long contarTodos() {
        return em.createQuery("SELECT COUNT(t) FROM Titulo t", Long.class)
                .getSingleResult();
    }

    public long contarPorTipo(TipoTitulo tipo) {
        return em.createQuery("SELECT COUNT(t) FROM Titulo t WHERE t.tipo = :tipo", Long.class)
                .setParameter("tipo", tipo)
                .getSingleResult();
    }

    public long contarConPoster() {
        return em.createQuery("""
                SELECT COUNT(DISTINCT t)
                FROM Titulo t JOIN t.archivos a
                WHERE a.tipoArchivo = com.juanpirir.catalogoapp.entidad.TipoArchivo.POSTER
            """, Long.class).getSingleResult();
    }
}
