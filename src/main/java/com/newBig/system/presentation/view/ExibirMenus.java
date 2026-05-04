package com.newBig.system.presentation.view;

import com.newBig.system.service.Verificar;
import com.newBig.system.service.AtualizarUsuario;
import com.newBig.system.repository.DadosUsuario;


public class ExibirMenus {
    AtualizarUsuario atualizar;
    Verificar verificar = new Verificar();
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
    public void principal(Long id){
        System.out.println("\n===============================");
        System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
        System.out.println("===============================");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Vender");
        System.out.println("3 - Caixa");
        System.out.println("4 - Trocar Usuario");
        System.out.println("0 - Sair");

        System.out.println("===============================");
        System.out.println("Usuario Logado: " + id + " - " + verificar.nomeLogado(id));
        System.out.println("===============================");
        System.out.print("Escolha uma opção: ");

    }

    public void cadastro(){
        System.out.println("\n===============================");
        System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
        System.out.println("===============================");
        System.out.println("            Cadastro          ");
        System.out.println("===============================");
        System.out.println("1 - Usuário");
        System.out.println("2 - Produto ");
        System.out.println("3 - Entrada/Lote");
        System.out.println("0 - Voltar");
        System.out.println("===============================");
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

    public void saleMenu() {
        System.out.println("\n===============================");
        System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
        System.out.println("===============================");
        System.out.println("            Vendas          ");
        System.out.println("===============================");
        System.out.println("1 - vender");
        System.out.println("0 - Voltar");
        System.out.println("===============================");
    }

}