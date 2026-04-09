package com.newBig.system.application.usecase;

import java.util.Scanner;

public class Pagamentos {
    Verificar verificar = new Verificar();
    Scanner sc = new Scanner(System.in);
    static double dinheiro = 0;
    static double cartao = 0;
    static double pix = 0;

    public void pagamento(double valor){
        System.out.println("\n===============================");
        System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
        System.out.println("          --Pagamento--        ");
        System.out.println("===============================");
        System.out.println("1 - Dinheiro");
        System.out.println("2 - Cartão");
        System.out.println("3 - Pix");
        switch (verificar.opcao()){
            case 1:
                dinheiro(valor);
                break;
            case 2:
                cartao(valor);
                break;
            case 3:
                pix(valor);
                break;
            default:
                System.out.println("Digite uma opcao disponivel!!!!");
                break;
        }
    }
    public void dinheiro(double valor){
        System.out.println("--Dinheiro--");
        System.out.println("Valor: R$" + valor);
        double recebido = 0;
        System.out.println("Digite o valor recebido");
        recebido = verificar.valor();
        if(recebido < valor){
            double restante = valor - recebido;
            String continuar;
            do {
                System.out.println("Valor faltando: R$" + restante);
                System.out.println("Valor recebido menor que o valor da compra, pagar o restante de outra forma (s/n): ");
                continuar = sc.nextLine().toLowerCase();
                if (continuar.equals("s")) {
                    System.out.println("1 - cartao");
                    System.out.println("2 - pix");
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
                            cartao(restante);
                            return;
                        case 2:
                            pix(recebido);
                            return;
                        default:
                            System.out.println("Digite uma opcao disponivel!!!!");
                            break;
                    }

                } else if (!continuar.equals("n")) {
                    System.out.println("Erro!!! Responda somente com s/n");
                }
            } while (!continuar.equals("n"));
            if (continuar.equals("n")){
                System.out.println("tente novamente! Enter continuar");
                sc.nextLine();
                dinheiro(valor);
            }
        }
        else{
            double troco = recebido - valor;

            dinheiro = valor;

            System.out.println("Troco: " + troco);
        }
    }
    public void cartao(double valor){
        System.out.println("--Cartao--");
        System.out.println("Valor: R$" + valor);

        String continuar;
        do {
            System.out.println("Pagamento realizado na maquininha (s/n): ");
            continuar = sc.nextLine().toLowerCase();
            if (continuar.equals("s")) {
                System.out.println("Pagamento concluido!!!");
                cartao += valor;
                break;
            } else if (!continuar.equals("n")) {
                System.out.println("Erro!!! Responda somente com s/n");
            }
        } while (!continuar.equals("n"));
        if(continuar.equals("n")){
            pagamento(valor);
        }
    }
    public void pix(double valor){
        System.out.println("--pix--");
        System.out.println("Valor: R$" + valor);

        String continuar;
        do {
            System.out.println("Pagamento realizado por pix (s/n): ");
            continuar = sc.nextLine().toLowerCase();
            if (continuar.equals("s")) {
                System.out.println("Pagamento concluido!!!");
                pix += valor;
                break;
            } else if (!continuar.equals("n")) {
                System.out.println("Erro!!! Responda somente com s/n");
            }
        } while (!continuar.equals("n"));
        if(continuar.equals("n")){
            pagamento(valor);
        }
    }
}
