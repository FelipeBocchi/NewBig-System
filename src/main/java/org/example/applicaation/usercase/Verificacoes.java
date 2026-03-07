package org.example.applicaation.usercase;

import org.example.domain.model.Funcionario;
import org.example.infrastructure.persistence.DadosUsuario;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Verificacoes {
    Scanner sc = new Scanner(System.in);
    public int acesso(){
        System.out.println("--Verificao de usuario--");
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
                if(id > DadosUsuario.usuario.size() || id < 0){
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




    public void limparBuffer() {
        this.sc.nextLine();
    }
}
