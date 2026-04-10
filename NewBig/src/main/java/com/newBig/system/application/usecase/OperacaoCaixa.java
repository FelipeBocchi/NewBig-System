package com.newBig.system.application.usecase;

import com.newBig.system.Main;
import com.newBig.system.domain.model.DadosCaixa;
import com.newBig.system.domain.model.Funcionario;
import com.newBig.system.domain.model.LogCaixa;
import com.newBig.system.domain.repository.*;
import com.newBig.system.infrastructure.persistence.Caixa;
import jakarta.persistence.EntityManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OperacaoCaixa {
    EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
    CaixaRepo caixaRepo = new CaixaRepo(em);
    FuncionarioRepo funcionarioRepo = new FuncionarioRepo(em);
    Verificar verificar = new Verificar();
    Scanner sc = new Scanner(System.in);
    DadosCaixa dados = new DadosCaixa();
    Caixa caixa = new Caixa();

    public void abrir(){
        if(caixaRepo.CaixaAberto() != null){
            System.out.println("Já tem um caixa aberto feche ele para continuar!!");
            Main.main(null);
        }
        if(!verificar.acesso(verificar.login(), 2)){
            Main.main(null);
        }
        else{
            System.out.println("\n===============================");
            System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
            System.out.println("===============================");
            System.out.println("          Abrir Caixa          ");
            System.out.println("===============================");
            System.out.println("Digite seu id: ");
            try{
                Long id = verificar.id();
                Funcionario usuarioAbertura = funcionarioRepo.SelecionarFuncionario(id);
                if(usuarioAbertura == null){
                    System.out.println("Id não encontrado!! Tente novamente");
                    abrir();
                    return;
                }
                System.out.println("Digite o valor de abertura: ");
                double valor = verificar.valor();
                if(valor <= 0){
                    System.out.println("Erro valor tem que ser maior que zero!!");
                    abrir();
                }
                dados.salvarAbertura(usuarioAbertura, valor);
                caixaRepo.create(dados);
                System.out.println("Caixa Aberto com sucesso!! (Precione Enter)");
                sc.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println("Valor digitado incorreto!! Tente novamente");
                abrir();
            }
            Main.main(null);
        }
    }

    public void fechar(){
        if(caixaRepo.CaixaAberto() == null){
            System.out.println("Nenhum caixa foi aberto!!");
            Main.main(null);
        }
        if(!verificar.acesso(verificar.login(), 2)){
            Main.main(null);
        }
        else{
            System.out.println("\n===============================");
            System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
            System.out.println("===============================");
            System.out.println("         Fechar Caixa          ");
            System.out.println("===============================");
            System.out.println("Digite seu id: ");
            try{
                Long id = verificar.id();
                Funcionario usuariofechamento = funcionarioRepo.SelecionarFuncionario(id);
                if(usuariofechamento == null){
                    System.out.println("Id não encontrado!! Tente novamente");
                    abrir();
                    return;
                }
                DadosCaixa dadosFechamento = caixaRepo.CaixaAberto();
                dadosFechamento.salvarFechamento(usuariofechamento, caixa.getValorAtual(), caixa.getSangria());
                caixaRepo.update(dadosFechamento);
                System.out.println("Caixa Fechado com sucesso!! (Precione Enter) ");
                sc.nextLine();
                caixa.zerarValor();
            }
            catch (InputMismatchException e){
                System.out.println("Valor digitado incorreto!! Tente novamente");
                fechar();
            }
            Main.main(null);
        }
    }

    public void consultar(){
        if(caixaRepo.CaixaAberto() == null){
            System.out.println("Nenhum caixa foi aberto!!");
            Main.main(null);
        }
        if(!verificar.acesso(verificar.login(), 1)){
            Main.main(null);
        }
        else{
            DadosCaixa dadosConsulta = caixaRepo.CaixaAberto();
            System.out.println("\n===============================");
            System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
            System.out.println("===============================");
            System.out.println("         Caixa: R$" + dadosConsulta.getValorAtual());
            System.out.println("===============================");
            System.out.println("Id do caixa: " + dadosConsulta.getId());
            System.out.println("Usuario abertura: " + dadosConsulta.getUsuarioAbertura().getId() + " - " + dadosConsulta.getUsuarioAbertura().getNome());
            System.out.println("Valor de abertura: " + dadosConsulta.getValorAbertura());
            System.out.println("Hora de Abertura: " + dadosConsulta.getHoraAbertura());
            System.out.println("Data de Abertura: " + dadosConsulta.getDataAbertura());
            System.out.println("--Enter para sair--");
            sc.nextLine();
            Main.main(null);
        }
    }

    public void sangria(){
        if(!verificar.acesso(verificar.login(), 1)){
            Main.main(null);
        }
        else{
            try{
                System.out.println("Valor da Sangria: ");
                double valor = sc.nextDouble();
                caixa.sangria(valor);
                System.out.println("Sangria no valor de R$" + valor + "Concluida com sucesso!!");
                Main.main(null);
            }
            catch (InputMismatchException e){
                System.out.println("Valor digitado incorreto!! Tente novamente");
                Main.main(null);
            }
        }
    }

    public void log(){
        if(!verificar.acesso(verificar.login(), 1)){
            Main.main(null);
        }
        else{
            LogCaixaRepo logCaixaRepo = new LogCaixaRepo(em);
            var logs = logCaixaRepo.listasLog();
            for (int i = 0; i < logs.size(); i++) {
                System.out.println(logs.get(i).getId() + " - " + logs.get(i).getDescricao() + " - " + logs.get(i).getData());
            }
            System.out.println("--Enter para sair--");
            sc.nextLine();
            Main.main(null);
        }
    }
}
