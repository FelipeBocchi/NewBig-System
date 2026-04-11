package com.newBig.system.application.usecase;

import com.newBig.system.Main;
import com.newBig.system.domain.model.Cliente;
import com.newBig.system.domain.model.Funcionario;
import com.newBig.system.domain.repository.ClienteRepo;
import com.newBig.system.domain.repository.CustomizerFactory;
import com.newBig.system.domain.repository.FuncionarioRepo;
import com.newBig.system.presentation.view.ClienteView;
import com.newBig.system.presentation.view.FuncionarioView;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class AtualizarUsuario {
    Scanner sc = new Scanner(System.in);
    FuncionarioView funcionarioView = new FuncionarioView();
    ClienteView clienteView = new ClienteView();
    Verificar verificar = new Verificar();
    EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
    FuncionarioRepo funcionarioRepo = new FuncionarioRepo(em);
    ClienteRepo clienteRepo = new ClienteRepo(em);

    public void iniciar(){
        System.out.println("\n===============================");
        System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
        System.out.println("===============================");
        System.out.println("       Atualizar Usuarios      ");
        System.out.println("===============================");
        System.out.println("1 - Cliente");
        System.out.println("2 - Funcionario");
        System.out.println("0 - Voltar");
        System.out.println("===============================");
        System.out.println("Opcao: ");
        int op = verificar.opcao();
        switch (op){
            case 1:
                cliente(0L);
                break;
            case 2:
                funcionario(0L);
                break;
            case 0:
                Main.main(null);
                break;
            default:
                System.out.println("Erro opcao invalida");
                iniciar();
        }
    }

    public void funcionario(Long id){
        funcionarioView.print();
        try{
            if(id == 0){
                id = verificar.id();
                if(!verificar.existe_id(id)){
                    funcionario(0L);
                }
            }
            Funcionario escolhido = funcionarioRepo.SelecionarFuncionario(id);
            System.out.println("===============================");
            System.out.println("1 - Id (Não é possivel alterar): " + escolhido.getId());
            System.out.println("2 - Nome: " + escolhido.getNome());
            System.out.println("3 - Cpf: " + escolhido.getCpf());
            System.out.println("4 - Acesso: " + escolhido.getAcesso());
            System.out.println("5 - Login: " + escolhido.getLogin());
            System.out.println("6 - Senha: " + escolhido.getSenha());
            System.out.println("0 - Voltar");
            System.out.println("===============================");
            System.out.println("Opcao: ");
            int op = verificar.opcao();
            switch (op){
                case 1:
                    System.out.println("Não é possivel alterar o id!!!");
                    funcionario(id);
                    break;

                case 2:
                    System.out.println("Nome: ");
                    String nome = sc.nextLine();
                    escolhido.setNome(nome);
                    break;

                case 3:
                    System.out.println("Cpf: ");
                    String cpf = sc.nextLine();
                    escolhido.setCpf(cpf);
                    break;

                case 4:
                    System.out.println("1 - Administrador");
                    System.out.println("2 - Operador");
                    System.out.println("3 - Sem acesso");
                    System.out.println("Opcao: ");
                    int acesso = sc.nextInt();
                    sc.nextLine();
                    escolhido.setAcesso(acesso);
                    break;

                case 5:
                    System.out.println("Login: ");
                    String login = sc.nextLine();
                    escolhido.setLogin(login);
                    break;

                case 6:
                    System.out.println("Senha: ");
                    escolhido.setSenha(verificar.senha());
                    break;

                case 0:
                    Main.main(null);
                    break;
                default:
                    System.out.println("Escolha uma opcao valida");
                    funcionario(0L);
                    break;
            }
            String continuar;
            do {
                System.out.println("Continuar alterando(s/n): ");
                continuar = sc.nextLine().toLowerCase();
                if (continuar.equals("s")) {
                    funcionario(id);
                    break;
                } else if (!continuar.equals("n")) {
                    System.out.println("Erro!!! Responda somente com s/n");
                }
            } while (!continuar.equals("n"));
            if(continuar.equals("n")){
                funcionarioRepo.update(escolhido);
                Main.main(null);
            }
        } catch (Exception e) {
            System.out.println("Erro ao Atualizar Funcionario!!!");
            funcionario(0L);
        }
    }

    public void cliente(Long id){
        clienteView.print();
        try{
            if(id == 0){
                id = verificar.id();
                if(!verificar.existe_id_cliente(id)){
                    cliente(0L);
                }
            }
            Cliente escolhido = clienteRepo.SelecionarCliente(id);
            System.out.println("===============================");
            System.out.println("1 - Id (Não é possivel alterar): " + escolhido.getId());
            System.out.println("2 - Nome: " + escolhido.getNome());
            System.out.println("3 - Cpf: " + escolhido.getCpf());
            System.out.println("4 - Cep: " + escolhido.getCep());
            System.out.println("5 - Rua: " + escolhido.getRua());
            System.out.println("6 - Numero: " + escolhido.getNumero());
            System.out.println("7 - Bairro: " + escolhido.getBairro());
            System.out.println("8 - Telefone: " + escolhido.getTelefone());
            System.out.println("0 - Voltar");
            System.out.println("===============================");
            System.out.println("Opcao: ");
            int op = verificar.opcao();
            switch (op){
                case 1:
                    System.out.println("Não é possivel alterar o id!!!");
                    funcionario(id);
                    break;

                case 2:
                    System.out.println("Nome: ");
                    String nome = sc.nextLine();
                    escolhido.setNome(nome);
                    break;

                case 3:
                    System.out.println("Cpf: ");
                    String cpf = sc.nextLine();
                    escolhido.setCpf(cpf);
                    break;

                case 4:
                    System.out.println("Cep: ");
                    String cep = sc.nextLine();
                    escolhido.setCep(cep);
                    break;

                case 5:
                    System.out.println("Rua: ");
                    String rua = sc.nextLine();
                    escolhido.setRua(rua);
                    break;

                case 6:
                    System.out.println("Numero: ");
                    int numero = sc.nextInt();
                    sc.nextLine();
                    escolhido.setNumero(numero);
                    break;

                case 7:
                    System.out.println("Bairro: ");
                    String bairro = sc.nextLine();
                    escolhido.setBairro(bairro);
                    break;

                case 8:
                    System.out.println("Telefone: ");
                    String telefone = sc.nextLine();
                    escolhido.setTelefone(telefone);
                    break;

                case 0:
                    Main.main(null);
                    break;
                default:
                    System.out.println("Escolha uma opcao valida");
                    funcionario(0L);
                    break;
            }
            String continuar;
            do {
                System.out.println("Continuar alterando(s/n): ");
                continuar = sc.nextLine().toLowerCase();
                if (continuar.equals("s")) {
                    cliente(id);
                    break;
                } else if (!continuar.equals("n")) {
                    System.out.println("Erro!!! Responda somente com s/n");
                }
            } while (!continuar.equals("n"));
            if(continuar.equals("n")){
                clienteRepo.update(escolhido);
                Main.main(null);
            }
        } catch (Exception e) {
            System.out.println("Erro ao Atualizar Funcionario!!!");
            cliente(0L);
        }
    }
}
