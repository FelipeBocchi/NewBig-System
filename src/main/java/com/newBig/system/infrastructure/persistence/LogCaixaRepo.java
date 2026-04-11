package com.newBig.system.infrastructure.persistence;

import com.newBig.system.domain.model.LogCaixa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

import java.util.List;

public class LogCaixaRepo {
    private EntityManager em;

    public LogCaixaRepo(EntityManager em) {
        this.em = em;
    }

    public List<LogCaixa> listasLog(){
        try{
            return em.createQuery( /*Query cria uma consulta no banco*/
                    "SELECT l FROM LogCaixa l", LogCaixa.class
            ).getResultList(); /*Executa a consulta*/
        }
        catch (PersistenceException e){
            System.out.println("Erro no banco!!!" + e.getMessage());
            return null;
        }
    }
}
