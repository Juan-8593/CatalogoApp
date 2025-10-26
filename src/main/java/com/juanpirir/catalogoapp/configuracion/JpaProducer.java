package com.juanpirir.catalogoapp.configuracion;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class JpaProducer {

    @Produces
    @PersistenceContext(unitName = "catalogoPU")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }
}
