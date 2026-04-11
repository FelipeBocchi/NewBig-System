package com.newBig.system.application.usecase;

import com.newBig.system.Main;
import com.newBig.system.domain.model.Cliente;
import com.newBig.system.domain.model.Funcionario;
import com.newBig.system.infrastructure.persistence.ClienteRepo;
import com.newBig.system.infrastructure.persistence.CustomizerFactory;
import com.newBig.system.infrastructure.persistence.FuncionarioRepo;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class CadastroUsuario {
    Scanner sc = new Scanner(System.in);
    EntityManager em = CustomizerFactory.getEntityManager();
    FuncionarioRepo funRepo = new FuncionarioRepo(em);
    ClienteRepo cliRepo = new ClienteRepo(em);
    Verificar verificar = new Verificar();
    public void novo(){
        if(!verificar.acesso(verificar.login(), 1)){
            Main.main(null);
        }
        else{
            System.out.println("--Novo--");
            String nome = "";
            String cpf = "";
            try {
                System.out.println("Digite o Nome: ");
                nome = sc.nextLine();
                System.out.println("Digite o CPF: ");
                cpf = sc.nextLine();
                System.out.println("1 - Cliente");
                System.out.println("2 - Funcionario");
            } catch (Exception e) {
                System.out.println("Erro!");
            }
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
            switch (op){
                case 1:
                    try{
                        String cep;
                        String rua;
                        int numero;
                        String bairro;
                        String telefone;
                        System.out.println("Cep: ");
                        cep = sc.nextLine();
                        System.out.println("Rua: ");
                        rua = sc.nextLine();
                        System.out.println("Numero: ");
                        numero = sc.nextInt();
                        limparBuffer();
                        System.out.println("Bairro: ");
                        bairro = sc.nextLine();
                        System.out.println("Telefone: ");
                        telefone = sc.nextLine();
                        Cliente cliente = new Cliente(nome,cpf,cep,rua,numero,bairro,telefone);
                        cliRepo.create(cliente);
                        Main.main(null);
                    }
                    catch (Exception e){
                        System.out.println("Erro!!");
                    }
                    break;
                case 2:
                    try{
                        int acesso;
                        String login;
                        int senha;
                        System.out.println("1 - Administrador");
                        System.out.println("2 - Operador");
                        System.out.println("3 - Sem acesso");
                        System.out.println("Digite o nivel de acesso: ");
                        acesso = sc.nextInt();
                        limparBuffer();
                        System.out.println("Login: ");
                        login = sc.nextLine();
                        System.out.println("senha:");
                        senha = verificar.senha();
                        Funcionario funcionario = new Funcionario(nome, cpf, acesso, login, senha);
                        funRepo.create(funcionario);
                        Main.main(null);
                    } catch (Exception e){
                        System.out.println("Erro!!");
                    }
                    break;

                default:
                    System.out.println("Escolhe uma opcao disponivel");
                    novo();
                    break;

            }
        }

    }

    public void limparBuffer(){sc.nextLine();}
}