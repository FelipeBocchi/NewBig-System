package com.newBig.system.model.repository;

import com.newBig.system.model.entity.LogUsuario;
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