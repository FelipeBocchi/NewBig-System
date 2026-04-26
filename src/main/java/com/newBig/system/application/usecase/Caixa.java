package com.newBig.system.application.usecase;

import com.newBig.system.infrastructure.persistence.CaixaRepo;
import com.newBig.system.infrastructure.persistence.CustomizerFactory;
import jakarta.persistence.EntityManager;

public class Caixa {
    EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
    CaixaRepo caixaRepo = new CaixaRepo(em);
    private static double valorAtual = 0.0 ;
    private static double sangria = 0.0;

    public void addValor(double n){
        valorAtual = caixaRepo.CaixaAberto().getValorAtual() +  n;
        upBanco();
    }

    public void retValor(double n){
        valorAtual = caixaRepo.CaixaAberto().getValorAtual() - n;
        upBanco();
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
        valorAtual = caixaRepo.CaixaAberto().getValorAtual();
        return valorAtual;
    }

    public void upBanco(){ /*atualiza o banco a cada mudança de caixa*/
        var banco = caixaRepo.CaixaAberto();
        banco.setValorAtual(valorAtual);
        caixaRepo.update(banco);
    }
}