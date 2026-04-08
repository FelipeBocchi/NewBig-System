package com.newBig.system.application.usecase;

import com.newBig.system.Main;
import com.newBig.system.domain.model.DadosCaixa;
import com.newBig.system.domain.model.Funcionario;
import com.newBig.system.domain.repository.CaixaRepo;
import com.newBig.system.domain.repository.ClienteRepo;
import com.newBig.system.domain.repository.CustomizerFactory;
import com.newBig.system.domain.repository.FuncionarioRepo;
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
            double valor = sc.nextDouble();
            sc.nextLine();
            dados.salvarAbertura(usuarioAbertura, valor);
            caixaRepo.create(dados);
            caixa.addValor(valor);
            System.out.println("Caixa Aberto com sucesso!! (Precione Enter)");
            sc.nextLine();
        }
        catch (InputMismatchException e){
            System.out.println("Valor digitado incorreto!! Tente novamente");
            abrir();
        }
        Main.main(null);
    }

    public void fechar(){
        if(caixaRepo.CaixaAberto() == null){
            System.out.println("Nenhum caixa foi aberto!!");
            Main.main(null);
        }
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

    public void consultar(){
        if(caixaRepo.CaixaAberto() == null){
            System.out.println("Nenhum caixa foi aberto!!");
            Main.main(null);
        }
        DadosCaixa dadosConsulta = caixaRepo.CaixaAberto();
        System.out.println("\n===============================");
        System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
        System.out.println("===============================");
        System.out.println("         Caixa: R$" + caixa.getValorAtual());
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

    public void sangria(){
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
