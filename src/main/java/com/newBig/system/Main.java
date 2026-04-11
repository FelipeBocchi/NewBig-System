package com.newBig.system;

import com.newBig.system.application.usecase.AddItemToSale;
import com.newBig.system.application.usecase.BuscarUsuarioVenda;
import com.newBig.system.application.usecase.Pagamentos;
import com.newBig.system.application.usecase.Verificar;
import com.newBig.system.config.FlyWayConfig;
import com.newBig.system.domain.repository.CustomizerFactory;
import com.newBig.system.domain.repository.ProductRepository;
import com.newBig.system.domain.repository.StockMovementRepository;
import com.newBig.system.domain.repository.StockRepository;
import com.newBig.system.infrastructure.persistence.MovementRepositoryImpl;
import com.newBig.system.infrastructure.persistence.ProductRepositoryImpl;
import com.newBig.system.infrastructure.persistence.StockRepositoryImpl;
import com.newBig.system.presentation.controller.AddItemController;
import com.newBig.system.presentation.controller.OpenSaleController;
import com.newBig.system.presentation.view.*;
import jakarta.persistence.EntityManager;

import java.util.Scanner;


public class Main {
    static boolean aux;
    static Long id = 0L;
    public static void main(String[] args) {
        UsuariosView usuariosView = new UsuariosView();
        MenuView menuView = new MenuView();
        Verificar verificar = new Verificar();
        CaixaView caixaView = new CaixaView();
        BuscarUsuarioVenda buscarUsuarioVenda = new BuscarUsuarioVenda();
        EntityManager em = CustomizerFactory.getEntityManager();

        StockRepository stockRepository = new StockRepositoryImpl(em);
        StockMovementRepository movementRepository = new MovementRepositoryImpl(em);
        ProductRepository productRepository = new ProductRepositoryImpl(em);

        SaleMenuView saleMenuView = new SaleMenuView();
        AddItemToSale addItemToSale = new AddItemToSale(em);
        AddItemController addItemController = new AddItemController(em);
        OpenSaleController openSaleController = new OpenSaleController(em, addItemToSale);
        Cadastros cadastros = new Cadastros();

        FlyWayConfig.migrate();
        if(!aux){
            System.out.println("\n===============================");
            System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
            System.out.println("===============================");
            id = verificar.login();
            aux = verificar.acesso(id, 2);
        }
            menuView.principal(id);
            switch (verificar.opcao()){
                case 1:
                    /*Usuario*/
                    cadastros.execute(productRepository, stockRepository, movementRepository);
                    break;
                case 2:
                    /*Caixa*/
                    caixaView.iniciar();
                    break;
                case 3:
                    /*trocar usuario*/
                    aux = false;
                    main(null);
                    break;
                case 4:
                    /*Vendas*/
                    saleMenuView.execute(openSaleController, addItemController);
                    break;
                case 0:
                    /*Sair*/
                    em.close();
                    break;
                default:
                    System.out.println("Escolha uma opcao valida!!");
                    main(null);
                    break;
            }
        }

}