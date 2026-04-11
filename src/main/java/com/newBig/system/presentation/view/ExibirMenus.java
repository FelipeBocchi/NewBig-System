package com.newBig.system.presentation.view;

import com.newBig.system.application.usecase.AtualizarUsuario;
import com.newBig.system.application.usecase.Verificar;



public class ExibirMenus {
    AtualizarUsuario atualizar;
    Verificar verificar = new Verificar();

    public void setAtualizar(AtualizarUsuario atualizar){
        this.atualizar = atualizar;
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