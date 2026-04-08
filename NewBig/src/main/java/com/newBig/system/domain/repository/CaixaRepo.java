package com.newBig.system.domain.repository;

import com.newBig.system.domain.model.Cliente;
import com.newBig.system.domain.model.DadosCaixa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.util.List;


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

    public DadosCaixa CaixaAberto(){ /*Busca caixa com status 0*/
        try{
            return em.createQuery(/*Query cria uma consulta no banco*/
                            "SELECT c FROM DadosCaixa c WHERE c.status = :status", DadosCaixa.class /*Define o retorno*/
                    )
                    .setParameter("status",0) /*Define o valor do parametro :nome*/
                    .getSingleResult(); /*Retorna um resultado*/
        }
        catch (NoResultException e){
            return null;
        }
    }

}
