package com.newBig.system.infrastructure.persistence;

import com.newBig.system.domain.model.DadosCaixa;

import java.util.ArrayList;

public class Caixa {
    public static ArrayList<DadosCaixa> caixa = new ArrayList<>();
    static DadosCaixa dados;
    public static float valorAtual = 0;
    public void abrirCaixa(int idUsuario, float valorAbertura){
        if(valorAtual == 0){
            dados = new DadosCaixa();
            dados.salvarAbertura(idUsuario, valorAbertura);
            addValor(valorAbertura);
            caixa.add(dados);
            System.out.println(caixa.toString());
        }
        else{
            System.out.println("Existe um caixa em aberto!!!");
        }
    }

    public void fecharCaixa(int idUsuario){
        if(valorAtual > 0.0){
            caixa.get(caixa.size() - 1).salvarFechamento(idUsuario, valorAtual); /*Salva depois de fechar*/
            valorAtual = 0; //limpa o caixa
            System.out.println(caixa.toString());
        }
        else{
            System.out.println("Caixa não aberto!!!!");
        }
    }

    public void addValor(float valor){
        if(valor >= 0){
            valorAtual += valor;
        }
        else{
            System.out.println("Valor invalido!!!!");
        }

    }

    public void retValor(float valor){
        if(valor >= 0){
            valorAtual -= valor;
        }
        else{
            System.out.println("Valor invalido!!!!!");
        }
    }
    public float getValorAtual(){
        return valorAtual;
    }

    public DadosCaixa dadosCaixaAberto(){
        if(valorAtual > 0.0){
            return dados;
        }
        else{
            System.out.println("Caixa não aberto!!!!");
        }
        return null;
    }

}
