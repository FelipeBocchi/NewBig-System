package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.Funcionario;
import com.newBig.system.infrastructure.persistence.DadosUsuario;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Verificacoes {
    Scanner sc = new Scanner(System.in);
    static String nomeLogado;
    static int idLogado = 0;


    public int acesso(){
        System.out.println("--Verificao de usuario--");
        if(idLogado != 0){
            String continuar;
            do{
                System.out.println("Usuario: " + DadosUsuario.usuario.get(idLogado - 1).getNome());
                System.out.println("Usuario está correto (s/n): ");
                continuar = sc.nextLine().toLowerCase();
                if(continuar.equals("s")){
                    int senha = senha();
                    if(senha == ((Funcionario) DadosUsuario.usuario.get(idLogado - 1)).getSenha()){
                        return ((Funcionario) DadosUsuario.usuario.get(idLogado - 1)).getAcesso();
                    }
                }
                else if(!continuar.equals("n")){
                    System.out.println("Erro!!! Responda somente com s/n");
                }
            }while(!continuar.equals("n"));

        }
        System.out.println("Login: ");
        String login = sc.nextLine();
        System.out.println("Senha: ");
        int senha = senha();
        for(int i = 0; i < DadosUsuario.usuario.size(); i++){
            if(DadosUsuario.usuario.get(i) instanceof Funcionario){
                if(login.equals(((Funcionario) DadosUsuario.usuario.get(i)).getLogin()) && senha == (((Funcionario) DadosUsuario.usuario.get(i)).getSenha())){
                    String continuar;
                    do{
                        System.out.println("Usuario: " + DadosUsuario.usuario.get(i).getNome());
                        System.out.println("Usuario está correto (s/n): ");
                        continuar = sc.nextLine().toLowerCase();
                        if(continuar.equals("s")){
                            return ((Funcionario) DadosUsuario.usuario.get(i)).getAcesso();
                        }
                        else if(!continuar.equals("n")){
                            System.out.println("Erro!!! Responda somente com s/n");
                        }
                    }while(!continuar.equals("n"));
                    acesso();
                    break;
                }
            }

        }
        System.out.println("Erro!! verifique o login e senha");
        return 0;
    }

    public int senha(){
        int senha = -1;
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
        return senha;
    }

    public String login(){
        System.out.println("Digite o Login: ");
        String login = sc.nextLine();
        for (int i = 0; i < DadosUsuario.usuario.size(); i++) {
            if (DadosUsuario.usuario.get(i) instanceof Funcionario){
                if(login.equals(((Funcionario) DadosUsuario.usuario.get(i)).getLogin())){
                    System.out.println("Escolha outro login!! Login já existente");
                    return login();
                }
            }

        }
        return login;
    }
    public int id(){
        boolean passou = false;
        int id = 0;
        do{
            try{
                System.out.println("Id: ");
                id = sc.nextInt();
                limparBuffer();
                if(id > DadosUsuario.usuario.size() || id <= 0){
                    System.out.println("Erro usuario não disponivel!!");
                }
                else{
                    passou = true;
                }
            }catch (InputMismatchException e){
                System.out.println("Erro, Digite somente numeros!!!");
                limparBuffer();
            }

        }while(!passou);
        return id;
    }

    public int usuarioDisponivel(){
        System.out.println("Digite seu identificador de usuario");
        int idOP = sc.nextInt() - 1;
        sc.nextLine();
        boolean loop = false;
        do{
            if(idOP >= DadosUsuario.usuario.size() || idOP < 0){
                System.out.println("Digite seu identificador de usuario");
                idOP = sc.nextInt() - 1;
                sc.nextLine();
            }
            else{
                String continuar;
                do {
                    System.out.println("Usuario: " + DadosUsuario.usuario.get(idOP).getNome());
                    System.out.println("Usuario está correto (s/n): ");
                    continuar = sc.nextLine().toLowerCase();
                    if (continuar.equals("s")) {
                        loop = true;
                        break;
                    } else if (!continuar.equals("n")) {
                        System.out.println("Erro!!! Responda somente com s/n");
                    }
                } while (!continuar.equals("n"));

            }
        }while (!loop);
        return idOP;
    }

    public boolean login(String login, int senha){
        for(int i = 0; i < DadosUsuario.usuario.size(); i++) {
            if (DadosUsuario.usuario.get(i) instanceof Funcionario) {
                if (login.equals(((Funcionario) DadosUsuario.usuario.get(i)).getLogin()) && senha == (((Funcionario) DadosUsuario.usuario.get(i)).getSenha())) {
                    String continuar;
                    do {
                        System.out.println("Usuario: " + DadosUsuario.usuario.get(i).getNome());
                        System.out.println("Usuario está correto (s/n): ");
                        continuar = sc.nextLine().toLowerCase();
                        if (continuar.equals("s")) {
                            nomeLogado = DadosUsuario.usuario.get(i).getNome();
                            idLogado = DadosUsuario.usuario.get(i).getId();
                            return true;
                        } else if (!continuar.equals("n")) {
                            System.out.println("Erro!!! Responda somente com s/n");
                        }
                    } while (!continuar.equals("n"));
                    login();
                    break;
                }
            }
        }
        System.out.println("Login ou senha incorretos!!!");
        return false;
    };

    public void retNomeLogado() {
        Verificacoes.nomeLogado = "";
    }

    public void retIdLogado() {
        Verificacoes.idLogado = 0;
    }

    public String getNomeLogado(){
        return nomeLogado;
    };

    public int getIdLogado(){
        return idLogado;
    };

    public float valor(){
        boolean passou = false;
        float n = 0;
        while (!passou) {
            System.out.print("Digite o valor: ");
            try {
                n = sc.nextFloat();
                passou = true;
            } catch (Exception e) {
                System.out.println("Numero invalido tente novamente");
                sc.nextLine();
            }
        }
        return n;

    };









    public void limparBuffer() {
        this.sc.nextLine();
    }
}