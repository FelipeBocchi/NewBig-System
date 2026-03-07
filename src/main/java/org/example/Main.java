package org.example;

import org.example.applicaation.usercase.AtualizarUsuario;
import org.example.applicaation.usercase.CadastroUsuario;
import org.example.applicaation.usercase.OperacaoUsuario;
import org.example.domain.model.Funcionario;
import org.example.presentation.view.ExibirMenus;
import org.example.infrastructure.persistence.DadosUsuario;

public class Main {
    public static void main(String[] args) {
        System.out.println("--Sorveteria New big--");
        DadosUsuario.usuario.add(new Funcionario("Admin", "000000000000", 1, "100", 1000));
        OperacaoUsuario operacaoUsuario = new OperacaoUsuario();
        ExibirMenus print = new ExibirMenus();
        AtualizarUsuario atualizar = new AtualizarUsuario();
        CadastroUsuario cadastrar = new CadastroUsuario();

        cadastrar.setOperacao(operacaoUsuario);
        atualizar.setObjetos(operacaoUsuario, print);
        print.setAtualizar(atualizar);
        operacaoUsuario.setObjetos(atualizar, print, cadastrar);
        operacaoUsuario.iniciar();
    }
}