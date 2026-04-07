package com.newBig.system.domain.repository;

import com.newBig.system.domain.model.DadosCaixa;
import jakarta.persistence.EntityManager;


public class CaixaRepo {

    private EntityManager em;

    public CaixaRepo(EntityManager em) {
        this.em = em;
    }

    public DadosCaixa findById(Long id){ /*SELECT * FROM usuario WHERE id = (id que envia) */
        return em.find(DadosCaixa.class, id);
    }

    public void create(DadosCaixa caixa){
        em.getTransaction().begin();
        em.merge(caixa);
        em.getTransaction().commit();
    }

    public void update(DadosCaixa caixa) {
        em.getTransaction().begin();
        em.merge(caixa);
        em.getTransaction().commit();
    }

}
