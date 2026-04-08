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
        try{
            em.getTransaction().begin();
            em.merge(dados);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback(); /* Não deixa salvar se dar erro */
            System.out.println("Erro ao salvar!! Nada foi salvo no Banco de dados");
        }

    }

    public void delete(Funcionario dados) {
        em.getTransaction().begin();
        em.remove(em.contains(dados) ? dados : em.merge(dados));
        em.getTransaction().commit();
    }

    public List<Funcionario> BuscaFuncionarios() {
        return em.createQuery( /*Query cria uma consulta no banco*/
                "SELECT f FROM Funcionario f", Funcionario.class
        ).getResultList(); /*Executa a consulta*/
    }

    public Funcionario SelecionarFuncionario(Long id) {
        try{
            return em.find(Funcionario.class, id); /*Busca pelo id*/
        }
        catch (jakarta.persistence.NoResultException e){
            System.out.println("Funcionario não encontrado no Banco de Dados");
            return null;
        }
    }

    public List<Funcionario> BuscaPorNome(String nome){
        return em.createQuery(/*Query cria uma consulta no banco*/
                        "SELECT f FROM Funcionario f WHERE f.nome LIKE :nome", Funcionario.class /*Define o retorno*/
                )
                .setParameter("nome", "%" + nome + "%") /*Define o valor do parametro :nome*/
                .getResultList(); /*Retorna a lista*/
    }
}
