package com.newBig.system.application.usecase;
import com.newBig.system.Main;
import com.newBig.system.infrastructure.persistence.DadosUsuario;
import com.newBig.system.presentation.view.ExibirMenus;

import java.util.Scanner;

public class OperacaoUsuario {
    Scanner sc = new Scanner(System.in);
    Verificacoes verificar = new Verificacoes();
    Utilidades util = new Utilidades();
    ExibirMenus print;
    AtualizarUsuario atualizar;
    CadastroUsuario cadastrar;
    //    Outras classes
    public void setObjetos(AtualizarUsuario atualizar, ExibirMenus print, CadastroUsuario cadastrar){
        this.atualizar = atualizar;
        this.print = print;
        this.cadastrar = cadastrar;
    }

    public void iniciar(){
        util.limpar();
        print.usuarios();
        int op;
        while(true){
            if(sc.hasNextInt()){
                op = sc.nextInt();
                break;
            }
            else{
                System.out.println("Digite algo valido!!!");
                limparBuffer();
            }
        }
        limparBuffer();
        switch (op){
            case 1:
                cadastrar.novo();
                break;
            case 2:
                atualizar.iniciar();
                break;
            case 3:
                relatoriosUsuarios();
                break;
            case 0:
                Main.main(null);
                break;
            default:
                System.out.println("Escolha uma opcao valida!!");
                iniciar();
        }
    }


    public void relatoriosUsuarios(){
        util.limpar();
        System.out.println("--Relatorio Usuario--");
        String continuar;
        do{
            print.printUsarios();
            System.out.println("Fazer login para ver os dados complementares (s/n)");
            continuar = sc.nextLine().toLowerCase();
            if(continuar.equals("s")){
                break;
            }
            else if(!continuar.equals("n")){
                System.out.println("Digite algo valido!!");
            }
        }while(!continuar.equals("n"));
        if(continuar.equals("n")){
            iniciar();
        }
        else{
            int resultadoVerificacao = verificar.acesso();
            util.limpar();
            print.printUsarios();
            if(resultadoVerificacao == 1){
                System.out.println("Digite o id do usario. ");
                int op = verificar.id();
                print.dadosComplementares(op);
            }
            else{
                System.out.println("Erro login ou senha invalidos!!");
                relatoriosUsuarios();
            }
            iniciar();
        }
    }
    public String getNomeById(int id){
        return DadosUsuario.usuario.get(id).getNome();
    }




    public void limparBuffer(){sc.nextLine();}




}