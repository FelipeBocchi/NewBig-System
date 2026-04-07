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

    public Cliente findById(Long id){ /*SELECT * FROM usuario WHERE id = (id que envia) */
        return em.find(Cliente.class, id);
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
        em.getTransaction().begin();
        em.merge(dados);
        em.getTransaction().commit();
    }

    public void delete(Cliente dados) {
        em.getTransaction().begin();
        em.remove(em.contains(dados) ? dados : em.merge(dados));
        em.getTransaction().commit();
    }

    public List<Cliente> BuscaCliente() {
        return em.createQuery( /*Query cria uma consulta no banco*/
                "SELECT c FROM Cliente c", Cliente.class
        ).getResultList(); /*Executa a consulta*/
    }

    public List<Cliente> BuscaPorNome(String nome){
        return em.createQuery(/*Query cria uma consulta no banco*/
                "SELECT c FROM Cliente c WHERE c.nome LIKE :nome", Cliente.class /*Define o retorno*/
        )
                .setParameter("nome", "%" + nome + "%") /*Define o valor do parametro :nome*/
                .getResultList(); /*Retorna a lista*/
    }
}
