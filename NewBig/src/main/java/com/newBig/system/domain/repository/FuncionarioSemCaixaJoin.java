package com.newBig.system.domain.repository;

import com.newBig.system.domain.model.DadosCaixa;
import com.newBig.system.domain.model.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

import java.util.List;

public class FuncionarioSemCaixaJoin {
    private EntityManager em;

    public FuncionarioSemCaixaJoin(EntityManager em) {
        this.em = em;
    }

    public List<Funcionario> join(){
        try{
            return em.createQuery( /*Consulta no banco*/
                    "SELECT f FROM Funcionario f LEFT JOIN f.dadosCaixa d WHERE d IS NULL", /*cria um left join dos funcionarios que nunca abriram caixa*/
                    Funcionario.class /*O resultado vai ser do tipo DadosCaixa*/
            ).getResultList(); /*Vai retornar uma lista*/
        }
        catch (PersistenceException e){
            System.out.println("Erro no Banco " + e.getMessage());
            return null;
        }
    }

}
