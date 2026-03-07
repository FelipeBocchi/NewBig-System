package org.example;

import org.example.dados.DadosUsuario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AtualizarUsuario {
    Scanner sc = new Scanner(System.in);
    Verificacoes verificar = new Verificacoes();
    OperacaoUsuario operacao;
    ExibirMenus print;

//    Outras classes
    public void setOperacao(OperacaoUsuario operacao){
        this.operacao = operacao;
    }
    public void setMenu(ExibirMenus print){
        this.print = print;
    }


    public void iniciar(){
        int resultadoVerificacao = verificar.acesso();
        if(resultadoVerificacao == 1){
            System.out.println("Selecione o ID do usuario que deseja alterar: ");
            int opId = sc.nextInt();
            opId--;
            if(opId > DadosUsuario.usuario.size() || opId < 0){
                System.out.println("Erro escolha um usuario disponivel!!");
                operacao.iniciar();
            }
            limparBuffer();
            print.printOpAtualizar(opId);
            String continuar;
            do{
                print.printUsarios();
                System.out.println("Continuar alterando mesmo usuario (s/n)");
                continuar = sc.nextLine().toLowerCase();
                if(continuar.equals("s")){
                    print.printOpAtualizar(opId);
                }
                else if(!continuar.equals("n")){
                    System.out.println("Erro!!! Responda somente com s/n");
                }
            }while(!continuar.equals("n"));
            operacao.iniciar();
        }
        else if(resultadoVerificacao != 0){
            System.out.println("Usuario não possui permição para alterar");
            operacao.iniciar();
        }
        else{
            System.out.println("Erro!!!!");
            iniciar();
        }

    }


    public void atualizarCliente(int opId){
        System.out.println("Selecione o numero do que deseja alterar: ");
        int op = sc.nextInt();
        limparBuffer();
        if(op < 1 || op > 5){
            System.out.println("Selecione uma opcao disponivel!!");
        }
        System.out.println("Digite: ");
        switch (op){
            case 1:
                String nome = sc.nextLine();
                DadosUsuario.usuario.get(opId).setNome(nome);
                break;
            case 2:
                String cpf = sc.nextLine();
                DadosUsuario.usuario.get(opId).setCpf(cpf);
                break;
            case 3:
                String cep = sc.nextLine();
                ((Cliente) DadosUsuario.usuario.get(opId)).setCep(cep);
                break;
            case 4:
                String rua = sc.nextLine();
                ((Cliente) DadosUsuario.usuario.get(opId)).setRua(rua);
                break;
            case 5:
                int numero = sc.nextInt();
                limparBuffer();
                ((Cliente) DadosUsuario.usuario.get(opId)).setNumero(numero);
                break;
            case 6:
                String bairro = sc.nextLine();
                ((Cliente) DadosUsuario.usuario.get(opId)).setBairro(bairro);
                break;
            case 7:
                String telefone = sc.nextLine();
                ((Cliente) DadosUsuario.usuario.get(opId)).setTelefone(telefone);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    public void atualizarFuncionario(int opId){
        System.out.println("Selecione o numero do que deseja alterar: ");
        int op = sc.nextInt();
        limparBuffer();
        if(op < 1 || op > 5){
            System.out.println("Selecione uma opcao disponivel!!");
        }
        System.out.println("Digite: ");
        switch (op){
            case 1:
                String nome = sc.nextLine();
                DadosUsuario.usuario.get(opId).setNome(nome);
                break;
            case 2:
                String cpf = sc.nextLine();
                DadosUsuario.usuario.get(opId).setCpf(cpf);
                break;
            case 3:
                int acesso = sc.nextInt();
                limparBuffer();
                ((Funcionario) DadosUsuario.usuario.get(opId)).setAcesso(acesso);
                break;
            case 4:
                String login = sc.nextLine();
                ((Funcionario) DadosUsuario.usuario.get(opId)).setLogin(login);
                break;
            case 5:
                int senha = sc.nextInt();
                while(senha < 1000 || senha > 9999){
                    try{
                        System.out.println("Digite a senha (somente numeros de 4 digitos): ");
                        senha = sc.nextInt();
                        limparBuffer();
                    }catch (InputMismatchException e){
                        System.out.println("Senha invalida, Tente Novamente");
                        limparBuffer();
                    }

                }
                limparBuffer();
                ((Funcionario) DadosUsuario.usuario.get(opId)).setSenha(senha);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }
    public void limparBuffer(){sc.nextLine();}



}
