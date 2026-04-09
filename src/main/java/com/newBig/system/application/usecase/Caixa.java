package com.newBig.system.application.usecase;

public class Caixa {
    private static double valorAtual = 0.0;
    private static double sangria = 0.0;
    public void addValor(double n){
        valorAtual += n;
    }

    public void retValor(double n){
        valorAtual -= n;
    }

    public void zerarValor(){
        valorAtual = 0.0;
        sangria = 0.0;
    }

    public void sangria(double n){
        sangria += n;
        retValor(n);
    }

    public double getSangria() {
        return sangria;
    }

    public double getValorAtual() {
        return valorAtual;
    }
}
