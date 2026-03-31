package com.newBig.system.presentation.view;

import com.newBig.system.application.usecase.Utilidades;
import com.newBig.system.application.usecase.Verificacoes;
import com.newBig.system.domain.model.Cliente;
import com.newBig.system.domain.model.Funcionario;
import com.newBig.system.domain.model.Usuario;
import com.newBig.system.application.usecase.AtualizarUsuario;
import com.newBig.system.infrastructure.persistence.DadosUsuario;


public class ExibirMenus {
    AtualizarUsuario atualizar;
    Utilidades util = new Utilidades();
    Verificacoes verificar = new Verificacoes();
    //    Pegar outras classes
    public void setAtualizar(AtualizarUsuario atualizar){
        this.atualizar = atualizar;
    }



    public void printUsarios(){
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-4s %-15s %-15s %-12s\n",
                "ID", "Nome", "CPF", "Acesso");

        System.out.println("-------------------------------------------------------------------");
        for (int i = 0; i < DadosUsuario.usuario.size(); i++) {
            System.out.println(DadosUsuario.usuario.get(i).toString());
        }

    }
    public void dadosComplementares(int id){
        id--;
        Usuario aux = DadosUsuario.usuario.get(id);
        if (aux instanceof Cliente) {
            System.out.println("-------------------------------------------------------------------");
            System.out.printf("%-4s %-15s %-15s %-12s\n", "ID", "Nome", "CPF", "Acesso");
            System.out.println("-------------------------------------------------------------------");
            System.out.println(((Cliente) aux).toString());
            System.out.println(((Cliente) aux).getDadosCliente());
        } else if (aux instanceof Funcionario) {
            System.out.println("-------------------------------------------------------------------");
            System.out.printf("%-4s %-15s %-15s %-12s\n", "ID", "Nome", "CPF", "Acesso");
            System.out.println("-------------------------------------------------------------------");
            System.out.println(((Funcionario) aux).toString());
            System.out.println(((Funcionario) aux).getDadosFuncionario());
        }
        util.limparBuffer();
    }
    public void printOpAtualizar(int opId){
        System.out.println("--Alterar dados Usuario--");
        System.out.println("1 - Nome");
        System.out.println("2 - Cpf");
        if (DadosUsuario.usuario.get(opId) instanceof Cliente){
            System.out.println("3 - Cep");
            System.out.println("4 - rua");
            System.out.println("5 - Numero");
            System.out.println("6 - Bairro");
            System.out.println("7 - Telefone");
            atualizar.atualizarCliente(opId);
        }
        else if(DadosUsuario.usuario.get(opId) instanceof Funcionario){
            System.out.println("3 - Acesso");
            System.out.println("4 - Login");
            System.out.println("5 - Senha");
            atualizar.atualizarFuncionario(opId);
        }
    }
    public void usuarios(){
        System.out.println("\n===============================");
        System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
        System.out.println("===============================");
        System.out.println("            Usuarios           ");
        System.out.println("===============================");
        System.out.println("1 - Novo cadastro");
        System.out.println("2 - Atualizar ");
        System.out.println("3 - Relatorio");
        System.out.println("0 - Voltar");
        System.out.println("===============================");
    }
    public void principal(){
        util.limpar();
        System.out.println("\n===============================");
        System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
        System.out.println("===============================");
        System.out.println("1 - Usuarios");
        System.out.println("2 - Produtos");
        System.out.println("3 - Caixa");
        System.out.println("4 - Trocar Usuario");
        System.out.println("0 - Sair");
        System.out.println("===============================");
        System.out.println("Usuario Logado: " + verificar.getIdLogado() + " - " + verificar.getNomeLogado());
        System.out.println("===============================");

        System.out.print("Escolha uma opção: ");

    }

}