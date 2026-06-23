package com.newBig.system.model.service.caixa;

import com.newBig.system.model.entity.DadosCaixa;
import com.newBig.system.model.entity.Funcionario;
import com.newBig.system.model.repository.CaixaRepo;
import com.newBig.system.model.repository.CustomizerFactory;
import jakarta.persistence.EntityManager;

public class Caixa {
    EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
    CaixaRepo caixaRepo = new CaixaRepo(em);
    DadosCaixa dadosCaixa = new DadosCaixa();
    private static Double valorAtual = null;
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
        valorAtual = null;
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

    public void update(DadosCaixa dadosCaixa) {
        caixaRepo.update(dadosCaixa);
    }

    public double getValorAbertura(){
        return caixaRepo.CaixaAberto().getValorAbertura();
    }

    public DadosCaixa getObjeto(){
        return caixaRepo.CaixaAberto();
    }

    public void abrirCaixa(Funcionario usuarioAbertura, double valor){
        dadosCaixa.salvarAbertura(usuarioAbertura, valor);
        caixaRepo.create(dadosCaixa);
    }

    public void fechar(Funcionario usuariofechamento){
        DadosCaixa dadosFechamento = caixaRepo.CaixaAberto();
        dadosFechamento.salvarFechamento(usuariofechamento, getValorAtual(), getSangria());
        caixaRepo.update(dadosFechamento);
        zerarValor();
    }

    public Double verificarAbertura(){
        return valorAtual;
    }


}