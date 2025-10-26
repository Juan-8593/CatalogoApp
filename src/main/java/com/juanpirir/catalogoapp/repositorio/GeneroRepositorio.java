package com.juanpirir.catalogoapp.repositorio;

import com.juanpirir.catalogoapp.entidad.Genero;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class GeneroRepositorio {

    @PersistenceContext(unitName = "catalogoPU")
    private EntityManager em;

    public void crear(Genero genero) {
        em.persist(genero);
    }

    public Genero actualizar(Genero genero) {
        return em.merge(genero);
    }

    public void eliminar(Long id) {
        Genero g = em.find(Genero.class, id);
        if (g != null) {
            em.remove(g);
        }
    }

    public Genero buscarPorId(Long id) {
        return em.find(Genero.class, id);
    }

    public List<Genero> listarTodos() {
        return em.createQuery("SELECT g FROM Genero g ORDER BY g.nombre", Genero.class)
                .getResultList();
    }

    public long contarTodos() {
        return em.createQuery("SELECT COUNT(g) FROM Genero g", Long.class)
                .getSingleResult();
    }
}
