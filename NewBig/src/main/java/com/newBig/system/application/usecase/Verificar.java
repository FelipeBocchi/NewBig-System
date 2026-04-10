package com.newBig.system.application.usecase;

import com.newBig.system.Main;
import com.newBig.system.domain.repository.ClienteRepo;
import com.newBig.system.domain.repository.CustomizerFactory;
import com.newBig.system.domain.repository.FuncionarioRepo;
import jakarta.persistence.EntityManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Verificar {
    Scanner sc = new Scanner(System.in);
    EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
    FuncionarioRepo funcionarioRepo = new FuncionarioRepo(em);
    ClienteRepo clienteRepo = new ClienteRepo(em);

    public int opcao(){
        try{
            int op;
            while(true){
                if(sc.hasNextInt()){
                    op = sc.nextInt();
                    break;
                }
                else{
                    System.out.println("Digite algo valido!!!");
                    sc.nextLine();
                }
            }
            sc.nextLine();
            return op;
        } catch (Exception e) {
            System.out.println("Erro ao escolher opcao");
            return 0;
        }
    } /*Opcao para switch*/


    public int senha(){
        int senha = -1;
        while(senha < 1000 || senha > 9999){
            try{
                System.out.println("Digite a senha (somente numeros de 4 digitos): ");
                senha = sc.nextInt();
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Senha invalida, Tente Novamente");
                sc.nextLine();
            }
        }
        return senha;
    } /*senha do funcionario*/

    public Long login(){
        System.out.println("--Verificar Usuario--");
        System.out.println("Login: ");
        String login = sc.nextLine();
        System.out.println("Senha: ");
        int senha = senha();
        var funcionarios = funcionarioRepo.BuscaFuncionarios();
        for (int i = 0; i < funcionarios.size(); i++) {
            if (login.equals(funcionarios.get(i).getLogin()) && senha == funcionarios.get(i).getSenha()){
                String continuar;
                do {
                    System.out.println("Usuario: " + funcionarios.get(i).getNome() + " (s/n)");
                    continuar = sc.nextLine().toLowerCase();
                    if (continuar.equals("s")) {
                        return funcionarios.get(i).getId();
                    } else if (!continuar.equals("n")) {
                        System.out.println("Erro!!! Responda somente com s/n");
                    }
                } while (!continuar.equals("n"));
                if(continuar.equals("n")){
                    System.out.println("Tente novamente!!!");
                    Main.main(null);
                }
            }
        }
        System.out.println("Login e senha invalidos!!");
        return login();
    }

    public boolean acesso(Long id, int nivel){
        var funcionario = funcionarioRepo.SelecionarFuncionario(id);
        if(id == null){
            return false;
        }
        else{
            if(funcionario.getAcesso() <= nivel){
                return true;
            }
            else{
                System.out.println("Funcionario sem acesso!!!");
                return false;
            }
        }
    }

    public String nomeLogado(Long id){
        var funcionarios = funcionarioRepo.BuscaFuncionarios();
        for (int i = 0; i < funcionarios.size(); i++) {
            if(funcionarios.get(i).getId().equals(id)){
                return funcionarios.get(i).getNome();
            }
        }
        return "Não encontrado";
    }

    public Long id(){
        Long id = 0L;
        while (true){
            try {
                System.out.print("Digite o ID: ");
                id = sc.nextLong();
                sc.nextLine();
                return id;
            }
            catch (java.util.InputMismatchException e){
                System.out.println("Digite apenas numeros!!");
                sc.nextLine();
            }
        }
    }

    public double valor(){
        boolean passou = false;
        double n = 0;
        while (!passou) {
            System.out.print("Digite o valor: ");
            try {
                n = sc.nextDouble();
                passou = true;
            } catch (Exception e) {
                System.out.println("Numero invalido tente novamente");
                sc.nextLine();
            }
        }
        return n;

    };

    public boolean existe_id(Long id){
        if(!funcionarioRepo.consultaId(id)){
            System.out.println("Id não encontrado no banco de dados!!!");
            return false;
        }
        return true;
    }

    public boolean existe_id_cliente(Long id){
        if(!clienteRepo.consultaId(id)){
            System.out.println("Id não encontrado no banco de dados!!!");
            return false;
        }
        return true;
    }

}
