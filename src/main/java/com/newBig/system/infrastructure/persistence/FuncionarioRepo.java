package com.newBig.system.infrastructure.persistence;

import com.newBig.system.Main;
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
            if(dados == null){
                System.out.println("funcionario nâo encontrado no banco");
                Main.main(null);
            }
            else{
                em.getTransaction().begin();
                em.merge(dados);
                em.getTransaction().commit();
            }
        }
        catch (Exception e){
            em.getTransaction().rollback(); /* Não deixa salvar se dar erro */
            System.out.println("Erro ao salvar!! Nada foi salvo no Banco de dados");
        }

    }

    public void delete(Funcionario dados) {
        try{
            if(dados == null){
                System.out.println("funcionario nâo encontrado no banco");
                Main.main(null);
            }
            else{
                em.getTransaction().begin();
                em.remove(em.contains(dados) ? dados : em.merge(dados));
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback(); /* Não deixa salvar se dar erro */
            System.out.println("Erro ao salvar!! Nada foi salvo no Banco de dados");
        }

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

    public boolean consultaId(Long id){
        return em.createQuery(
                "SELECT COUNT(e) > 0 FROM Funcionario e WHERE e.id = :id", Boolean.class
        ).setParameter("id", id).getSingleResult();
    }
}