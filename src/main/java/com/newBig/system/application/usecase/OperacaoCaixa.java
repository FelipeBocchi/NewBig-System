package com.newBig.system.application.usecase;

import com.newBig.system.Main;
import com.newBig.system.infrastructure.persistence.Caixa;

import java.util.Scanner;

public class OperacaoCaixa {
    Caixa caixa = new Caixa();
    Verificacoes verificar = new Verificacoes();
    OperacaoUsuario operacaoUsuario = new OperacaoUsuario();
    Scanner sc = new Scanner(System.in);
    public void menuCaixa(){
        System.out.println("\n===============================");
        System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
        System.out.println("===============================");
        System.out.println("            $Caixa$            ");
        System.out.println("===============================");
        System.out.println("1 - Abrir Caixa");
        System.out.println("2 - Fechar Caixa ");
        System.out.println("3 - Consultar caixa atual");
        System.out.println("4 - Sangria");
        System.out.println("5 - Historico do dia");
        System.out.println("0 - Voltar");
        System.out.println("===============================");
        System.out.println("Digite: ");
        int op;
        while(true){
            if(sc.hasNextInt()){
                op = sc.nextInt();
                break;
            }
            else{
                System.out.println("Digite algo valido!!!");
                sc.nextLine();
            }
        }
        sc.nextLine();
        switch (op){
            case 1:
                abrir();
                break;
            case 2:
                fechar();
                break;
            case 3:
                consultar();
                break;
            case 4:
                sangria();
                break;
            case 5:
                historico();
                break;
            case 0:
                Main.main(null);
                break;
            default:
                System.out.println("Digite uma opcao valida");
                menuCaixa();
                break;
        }
    }

    public void abrir(){
        int resultadoVerificacao = verificar.acesso();
        if(resultadoVerificacao == 1){
            System.out.println("--Abertura do Caixa--");
            int idUsuario = verificar.usuarioDisponivel();
            System.out.println("Digite o valor de abertura: ");
            float valorAbertura= verificar.valor();
            caixa.abrirCaixa(idUsuario, valorAbertura);
            Main.main(null);
        }
        else{
            System.out.println("Erro login ou senha invalidos!!");
            Main.main(null);
        }
    }

    public void fechar(){
        int resultadoVerificacao = verificar.acesso();
        if(resultadoVerificacao == 1){
            System.out.println("--Fechamento do Caixa--");
            int idUsuario = verificar.usuarioDisponivel();
            caixa.fecharCaixa(idUsuario);
            Main.main(null);
        }
        else{
            System.out.println("Erro login ou senha invalidos!!");
            Main.main(null);
        }
    }

    public void add(float valor){ /*Adiciona ao caixa*/
        caixa.addValor(valor);
    }
    public void sub(float valor){ /*retira do caixa*/
        caixa.retValor(valor);
    }

    public void sangria(){
        if(caixa.getValorAtual() == 0){
            System.out.println("Caixa não aberto!!!!");
            Main.main(null);
        }
        int resultadoVerificacao = verificar.acesso();
        if(resultadoVerificacao == 1){
            System.out.println("--Sangria do Caixa--");
            int idUsuario = verificar.usuarioDisponivel();
            System.out.println("Digite o valor de retirada: ");
            float valorRetirado= verificar.valor();
            if(valorRetirado > caixa.getValorAtual()){
                System.out.println("Valor maior que valor em caixa!!!!");
                System.out.println("--Enter para continuar--");
                menuCaixa();
            }
            else{
                caixa.addSangria(valorRetirado);
                sub(valorRetirado);
                Main.main(null);
            }

        }
        else{
            System.out.println("Erro login ou senha invalidos!!");
            Main.main(null);
        }
    };

    public void consultar(){
        int resultadoVerificacao = verificar.acesso();
        if(resultadoVerificacao == 1){
            System.out.println("\n===============================");
            System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
            System.out.println("===============================");
            System.out.println("Valor em caixa R$" + caixa.getValorAtual());
            System.out.println("===============================");
            try{
                System.out.println("Id do caixa: " + caixa.dadosCaixaAberto().getId());
                System.out.println("ID Usuario abertura: "+ caixa.dadosCaixaAberto().getIdUsuarioAbertura() + " (" + operacaoUsuario.getNomeById(caixa.dadosCaixaAberto().getIdUsuarioAbertura()) +")");
                System.out.println("Valor de abertura: " + caixa.dadosCaixaAberto().getValorAbertura());
                System.out.println("Hora de Abertura: " + caixa.dadosCaixaAberto().getHoraAbertura());
                System.out.println("Data de Abertura: " + caixa.dadosCaixaAberto().getDataAbertura());
                System.out.println("Valor de Sangria: " + caixa.getSangria());
            } catch (Exception e) {
                System.out.println("Caixa nao aberto");
                menuCaixa();
            }
            System.out.println("===============================");
            System.out.println("--Precione enter para sair--");
            sc.nextLine();
            Main.main(null);
        }
        else{
            System.out.println("Erro login ou senha invalidos!!");
            Main.main(null);
        }
    };

    public void historico(){
        int resultadoVerificacao = verificar.acesso();
        if(resultadoVerificacao == 1){
            System.out.println("\n===============================");
            System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
            System.out.println("===============================");
            System.out.println("    --Historico de Caixa--     ");
            System.out.println("===============================");
            for (int i = 0; i < caixa.arrayCaixa().size(); i++) {
                System.out.println(caixa.arrayCaixa().get(i).toString());
            }


        }
        else{
            System.out.println("Erro login ou senha invalidos!!");
            Main.main(null);
        }
    };

}
