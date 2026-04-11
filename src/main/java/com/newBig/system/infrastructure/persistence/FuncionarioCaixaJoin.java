package com.newBig.system.infrastructure.persistence;

import com.newBig.system.domain.model.DadosCaixa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

import java.util.List;

public class FuncionarioCaixaJoin {
    private EntityManager em;

    public FuncionarioCaixaJoin(EntityManager em) {
        this.em = em;
    }

    public List<DadosCaixa> join(){
        try{
            return em.createQuery( /*Consulta no banco*/
                    "SELECT d FROM DadosCaixa d JOIN d.usuarioAbertura", /*cria um inner join dos usuarios que abriram caixa*/
                    DadosCaixa.class /*O resultado vai ser do tipo DadosCaixa*/
            ).getResultList(); /*Vai retornar uma lista*/
        }
        catch (PersistenceException e){
            System.out.println("Erro no Banco " + e.getMessage());
            return null;
        }
    }
}