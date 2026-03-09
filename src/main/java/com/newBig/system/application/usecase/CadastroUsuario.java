package com.newBig.system.applicaation.usercase;

import com.newBig.system.domain.model.Cliente;
import com.newBig.system.domain.model.Funcionario;
import com.newBig.system.infrastructure.persistence.DadosUsuario;

import java.util.Scanner;

public class CadastroUsuario {
    com.newBig.system.applicaation.usercase.OperacaoUsuario operacao;
    com.newBig.system.applicaation.usercase.Verificacoes verificar = new com.newBig.system.applicaation.usercase.Verificacoes();
    public void setOperacao(com.newBig.system.applicaation.usercase.OperacaoUsuario operacao){this.operacao = operacao;}
    Scanner sc = new Scanner(System.in);
    public void novo(){
        System.out.println("--Novo--");
        String nome;
        String cpf;
        System.out.println("Digite o Nome: ");
        nome = sc.nextLine();
        System.out.println("Digite o CPF: ");
        cpf = sc.nextLine();
        for (int i = 0; i < DadosUsuario.usuario.size(); i++) {
            if (DadosUsuario.usuario.get(i).getCpf().equals(cpf)){
                System.out.println("Erro!! Cpf já cadastrado");
            }
        }
        System.out.println("--Novo--");
        System.out.println("1 - Cliente");
        System.out.println("2 - Funcionario");
        System.out.println("3 - Voltar");
        int op = sc.nextInt();
        limparBuffer();
        switch (op){
            case 1:
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
                DadosUsuario.usuario.add(new Cliente(nome,cpf,cep,rua,numero,bairro,telefone));
                operacao.iniciar();
                break;
            case 2:
                int acesso;
                String login;
                int senha;
                System.out.println("Digite o nivel de acesso: ");
                acesso = sc.nextInt();
                limparBuffer();
                login = verificar.login();
                senha = verificar.senha();
                DadosUsuario.usuario.add(new Funcionario(nome,cpf,acesso,login,senha));
                operacao.iniciar();
                break;

            case 3:
                operacao.iniciar();
                break;
            default:
                System.out.println("Escolhe uma opcao disponivel");
                novo();
                break;

        }

    }

    public void limparBuffer(){sc.nextLine();}

}