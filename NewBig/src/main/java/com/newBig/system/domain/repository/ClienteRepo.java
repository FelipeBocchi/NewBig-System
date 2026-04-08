package com.newBig.system.domain.repository;

import com.newBig.system.domain.model.Cliente;
import com.newBig.system.domain.model.Funcionario;
import jakarta.persistence.EntityManager;

import java.lang.ref.Cleaner;
import java.util.List;

public class ClienteRepo {

    private EntityManager em;

    public ClienteRepo(EntityManager em) {
        this.em = em;
    }


    public void create(Cliente dados){
        try{
            em.getTransaction().begin(); /*Comeca o banco*/
            em.merge(dados); /*Salva no banco*/
            em.getTransaction().commit(); /*Confirma a mudança*/
        } catch (Exception e) {
            em.getTransaction().rollback(); /* Não deixa salvar se dar erro */
            System.out.println("Erro ao salvar!! Nada foi salvo no Banco de dados");
        }
    }

    public void update(Cliente dados) {
        try{
            em.getTransaction().begin();
            em.merge(dados); /*Salva*/
            em.getTransaction().commit(); /*Confirma*/
        }
        catch (Exception e){
            em.getTransaction().rollback(); /* Não deixa salvar se dar erro */
            System.out.println("Erro ao atualizar!! Nada foi salvo no Banco de dados");
        }
    }

    public void delete(Cliente dados) {
        try{
            em.getTransaction().begin();
            em.remove(em.contains(dados) ? dados : em.merge(dados));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback(); /* Não deixa salvar se dar erro */
            System.out.println("Erro ao deletar!! Nada foi salvo no Banco de dados");
        }
    }

    public List<Cliente> BuscaCliente() { /*Busca todos os clientes*/
        return em.createQuery( /*Query cria uma consulta no banco*/
                "SELECT c FROM Cliente c", Cliente.class
        ).getResultList(); /*Executa a consulta*/
    }

    public List<Cliente> BuscaPorNome(String nome){ /*Busca os clientes pelo nome não precisa ser o nome inteiro*/
        return em.createQuery(/*Query cria uma consulta no banco*/
                "SELECT c FROM Cliente c WHERE c.nome LIKE :nome", Cliente.class /*Define o retorno*/
        )
                .setParameter("nome", "%" + nome + "%") /*Define o valor do parametro :nome*/
                .getResultList(); /*Retorna a lista*/
    }

    public Cliente SelecionarCliente(Long id) { /*Busca pelo id do cliente*/
        return em.find(Cliente.class, id); /*busca no banco pelo id*/
    }
}
