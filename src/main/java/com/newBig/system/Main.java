package com.newBig.system;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import com.newBig.system.application.usecase.OperacaoCaixa;
import com.newBig.system.application.usecase.Pagamentos;
import com.newBig.system.domain.model.Funcionario;
import com.newBig.system.domain.repository.ProductRepository;
import com.newBig.system.domain.repository.StockMovementRepository;
import com.newBig.system.domain.repository.StockRepository;
import com.newBig.system.infrastructure.persistence.*;
import com.newBig.system.presentation.view.Cadastros;
import com.newBig.system.presentation.view.*;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.newBig.system.presentation.view.IniciarUsuario;
import com.newBig.system.presentation.view.ExibirMenus;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Hibernate;

import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);

    static boolean rodou = false; /*Gerar o Admin sempre na primeira vez, e fazer login*/

    public static void main(String[] args) {

        //  = Conecção com o banco e inicialização
        EntityManager em = CustomizerFactory.getEntityManager();

        StockRepository stockRepository = new StockRepositoryImpl(em);
        StockMovementRepository movementRepository = new MovementRepositoryImpl(em);
        ProductRepository productRepository = new ProductRepositoryImpl(em);

        //ProductRepository repository = new ProductMemoryRepository();
        //StockRepository stockRepository = new StockMemoryRepository();
        //StockMovementRepository stockMovementRepository = new MovementMemoryRepository();

        Cadastros cadastros = new Cadastros();
        ExibirMenus menu = new ExibirMenus();
        OperacaoCaixa caixa = new OperacaoCaixa();
        IniciarUsuario iniciarUsuario = new IniciarUsuario();
        LoginUsuario login = new LoginUsuario();
        Pagamentos pagar = new Pagamentos(); /*testando se vai funcionar, tirar antes da entrega*/

        if(!rodou){/*Gerar o Admin sempre na primeira vez, e fazer login*/
            DadosUsuario.usuario.add(new Funcionario("Admin", "000000000000", 1, "100", 1000)); /*Admin para ter um usuario para fazer o login*/
            login.login();
            rodou = true; /*Nao rodar mais*/
        }

        menu.principal();
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
                cadastros.execute(productRepository, stockRepository, movementRepository, iniciarUsuario);
                break;
            case 2:

                break;

            case 3:
                caixa.menuCaixa();
                break;
            case 4:
                login.login();
                main(null);
                break;
            case 5:
                pagar.pagamento(10);
                break;
            case 0:
                /*Sair*/
                em.close();
                break;
            default:
                System.out.println("Escolha uma opcao valida!!");
                main(null);
        }


    }
}

