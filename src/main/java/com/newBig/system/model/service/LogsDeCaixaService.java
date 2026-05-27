package com.newBig.system.model.service;

import com.newBig.system.model.entity.LogCaixa;
import com.newBig.system.model.repository.CustomizerFactory;
import com.newBig.system.model.repository.LogCaixaRepo;
import jakarta.persistence.EntityManager;

import java.util.List;

public class LogsDeCaixaService {
    EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
    LogCaixaRepo logCaixaRepo = new LogCaixaRepo(em);

    public List<LogCaixa> lista(){
        return logCaixaRepo.listasLog();
    }
}
