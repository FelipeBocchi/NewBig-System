package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("--Sorveteria New big--");

        OperacaoUsuario operacaoUsuario = new OperacaoUsuario();
        ExibirMenus print = new ExibirMenus();
        AtualizarUsuario atualizar = new AtualizarUsuario();

        atualizar.setOperacao(operacaoUsuario);
        atualizar.setMenu(print);
        print.setAtualizar(atualizar);
        operacaoUsuario.setMenu(print);
        operacaoUsuario.setAtualizar(atualizar);
        operacaoUsuario.iniciar();
    }
}