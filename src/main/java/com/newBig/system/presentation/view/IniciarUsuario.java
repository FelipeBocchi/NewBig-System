package com.newBig.system.presentation.view;

import com.newBig.system.application.usecase.AtualizarUsuario;
import com.newBig.system.application.usecase.CadastroUsuario;
import com.newBig.system.application.usecase.OperacaoUsuario;
import com.newBig.system.domain.model.Funcionario;
import com.newBig.system.infrastructure.persistence.DadosUsuario;

public class IniciarUsuario {
    public void iniciar(){
        System.out.println("--Sorveteria New big--");
        /*Iniciar com o admin*/DadosUsuario.usuario.add(new Funcionario("Admin", "000000000000", 1, "100", 1000));
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
/*  Para chamar ele em outro lugar:
        import com.newBig.system.presentation.view.MenuUsuario;
            MenuUsuario menuUsuario = new MenuUsuario();
            menuUsuario.iniciar();
*/