package com.newBig.system.presentation.view.Morv;

import com.newBig.system.Main;
import com.newBig.system.application.usecase.AtualizarUsuario;
import com.newBig.system.application.usecase.CadastroUsuario;
import com.newBig.system.application.usecase.Verificar;

public class UsuariosView {
    Verificar verificar = new Verificar();
    CadastroUsuario cadastroUsuario = new CadastroUsuario();
    AtualizarUsuario atualizarUsuario = new AtualizarUsuario();
    RelatorioUsuarioView relatorioUsuario = new RelatorioUsuarioView();
    DeletarUsuarioView deletarUsuarioView = new DeletarUsuarioView();
    LogUsuarioView logUsuarioView = new LogUsuarioView();
    CaixaFuncionarioView caixaFuncionarioView = new CaixaFuncionarioView();
    FuncionarioSemCaixaView funcionarioSemCaixaView = new FuncionarioSemCaixaView();
    public void print(){
        System.out.println("\n===============================");
        System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM ");
        System.out.println("===============================");
        System.out.println("            Usuarios           ");
        System.out.println("===============================");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Atualizar");
        System.out.println("3 - Buscar");
        System.out.println("4 - Deletar");
        System.out.println("5 - Logs");
        System.out.println("6 - Funcionarios que abriram caixa");
        System.out.println("7 - Funcionarios que nuncao abriram caixa");
        System.out.println("0 - Voltar");
        System.out.println("===============================");
        switch (verificar.opcao()){
            case 1:
                cadastroUsuario.novo();
                break;
            case 2:
                atualizarUsuario.iniciar();
                break;
            case 3:
                relatorioUsuario.iniciar();
                break;
            case 4:
                deletarUsuarioView.iniciar();
                break;
            case 5:
                logUsuarioView.print();
                break;
            case 6:
                caixaFuncionarioView.print();
                break;
            case 7:
                funcionarioSemCaixaView.print();
                break;
            case 0:
                Main.main(null);
                break;
            default:
                System.out.println("Escolha uma opcao disponivel!!");
                print();
                break;
        }
    }
}