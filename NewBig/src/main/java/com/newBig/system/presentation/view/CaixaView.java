package com.newBig.system.presentation.view;

import com.newBig.system.Main;
import com.newBig.system.application.usecase.OperacaoCaixa;
import com.newBig.system.application.usecase.Verificar;

public class CaixaView {
    Verificar verificar = new Verificar();
    OperacaoCaixa operacaoCaixa = new OperacaoCaixa();
    public void iniciar(){
        System.out.println("\n===============================");
        System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
        System.out.println("===============================");
        System.out.println("            $Caixa$            ");
        System.out.println("===============================");
        System.out.println("1 - Abrir Caixa");
        System.out.println("2 - Fechar Caixa ");
        System.out.println("3 - Consultar caixa atual");
        System.out.println("4 - Sangria");
        System.out.println("0 - Voltar");
        System.out.println("===============================");
        System.out.println("Digite: ");
        switch (verificar.opcao()){
            case 1:
                operacaoCaixa.abrir();
                break;
            case 2:
                operacaoCaixa.fechar();
                break;
            case 3:
                operacaoCaixa.consultar();
                break;
            case 4:
                operacaoCaixa.sangria();
                break;
            case 0:
                Main.main(null);
                break;
            default:
                System.out.println("Escolha uma opcao disponivel!!");
                iniciar();
                break;
        }
    }

}
