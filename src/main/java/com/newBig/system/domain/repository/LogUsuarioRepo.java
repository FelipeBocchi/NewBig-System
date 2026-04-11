package com.newBig.system.domain.repository;

import com.newBig.system.domain.model.LogUsuario;
import jakarta.persistence.EntityManager;

import java.util.List;

public class LogUsuarioRepo {
    private EntityManager em;

    public LogUsuarioRepo(EntityManager em) {
        this.em = em;
    }

    public List<LogUsuario> listasLog(){
        return em.createQuery( /*Query cria uma consulta no banco*/
                "SELECT l FROM LogUsuario l", LogUsuario.class
        ).getResultList(); /*Executa a consulta*/
    }

}
