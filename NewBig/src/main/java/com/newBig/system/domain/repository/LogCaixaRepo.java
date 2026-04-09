package com.newBig.system.domain.repository;

import com.newBig.system.domain.model.LogCaixa;
import com.newBig.system.domain.model.LogUsuario;
import jakarta.persistence.EntityManager;

import java.util.List;

public class LogCaixaRepo {
    private EntityManager em;

    public LogCaixaRepo(EntityManager em) {
        this.em = em;
    }

    public List<LogCaixa> listasLog(){
        return em.createQuery( /*Query cria uma consulta no banco*/
                "SELECT l FROM LogCaixa l", LogCaixa.class
        ).getResultList(); /*Executa a consulta*/
    }
}
