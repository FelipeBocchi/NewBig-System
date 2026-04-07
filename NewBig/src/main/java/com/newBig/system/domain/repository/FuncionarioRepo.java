package com.newBig.system.domain.repository;

import com.newBig.system.domain.model.Cliente;
import com.newBig.system.domain.model.Funcionario;
import jakarta.persistence.EntityManager;

import java.util.List;


public class FuncionarioRepo {

    private EntityManager em;

    public FuncionarioRepo(EntityManager em) {
        this.em = em;
    }

    public Funcionario findById(Long id){ /*SELECT * FROM usuario WHERE id = (id que envia) */
        return em.find(Funcionario.class, id);
    }

    public void create(Funcionario dados){
        try {
            em.getTransaction().begin(); /*Comeca o banco*/
            em.merge(dados); /*Salva no banco*/
            em.getTransaction().commit(); /*Confirma a mudança*/
        } catch (Exception e) {
            em.getTransaction().rollback(); /* Não deixa salvar se dar erro */
            System.out.println("Erro ao salvar!! Nada foi salvo no Banco de dados");
        }
    }

    public void update(Funcionario dados) {
        em.getTransaction().begin();
        em.merge(dados);
        em.getTransaction().commit();
    }

    public void delete(Funcionario dados) {
        em.getTransaction().begin();
        em.remove(em.contains(dados) ? dados : em.merge(dados));
        em.getTransaction().commit();
    }

    public List<Funcionario> BuscaFuncionarios() {
        return em.createQuery( /*Query cria uma consulta no banco*/
                "SELECT c FROM Funcionario c", Funcionario.class
        ).getResultList(); /*Executa a consulta*/
    }
}
