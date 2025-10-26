package com.juanpirir.catalogoapp;

import com.juanpirir.catalogoapp.entidad.TipoTitulo;
import com.juanpirir.catalogoapp.entidad.Titulo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestConexion {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogoPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Titulo t = new Titulo();
            t.setNombre("Matrix");
            t.setAnioLanzamiento(1999);
            t.setTipoTitulo(TipoTitulo.PELICULA);
            em.persist(t);

            em.getTransaction().commit();
            System.out.println("✅ Registro guardado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
