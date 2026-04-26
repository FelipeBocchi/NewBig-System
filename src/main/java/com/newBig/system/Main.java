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
import com.newBig.system.presentation.view.Cadastros;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.newBig.system.presentation.view.ExibirMenus;

import com.newBig.system.presentation.view.Morv.CaixaView;
import com.newBig.system.presentation.view.SaleMenuView;
import jakarta.persistence.EntityManager;

import java.util.Scanner;


public class Main {
    static boolean aux;
    static Long id = 0L;

    public static void main(String[] args) {
        FlyWayConfig.migrate();
        //  = Conecção com o banco e inicialização
        EntityManager em = CustomizerFactory.getEntityManager();

        StockRepository stockRepository = new StockRepositoryImpl(em);
        StockMovementRepository movementRepository = new MovementRepositoryImpl(em);
        ProductRepository productRepository = new ProductRepositoryImpl(em);

        SaleMenuView saleMenuView = new SaleMenuView();
        AddItemToSale addItemToSale = new AddItemToSale(em);
        AddItemController addItemController = new AddItemController(em);
        OpenSaleController openSaleController = new OpenSaleController(em, addItemToSale);

        Cadastros cadastros = new Cadastros();
        ExibirMenus menu = new ExibirMenus();

        Verificar verificar = new Verificar();
        CaixaView caixaView = new CaixaView();
        Pagamentos pagamentos = new Pagamentos();
        Scanner sc = new Scanner(System.in);
        BuscarUsuarioVenda buscarUsuarioVenda = new BuscarUsuarioVenda();

        if(!aux){
            System.out.println("\n===============================");
            System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
            System.out.println("===============================");
            id = verificar.login();
            aux = verificar.acesso(id, 2);
        }

        int op;

        do {
            menu.principal(id);

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
                    cadastros.execute(productRepository, stockRepository, movementRepository);
                    break;
                case 2:
                    // vendas
                    saleMenuView.execute(openSaleController, addItemController);
                    break;

                case 3:
                    caixaView.iniciar();
                    break;
                case 4:
                    /*trocar usuario*/
                    aux = false;
                    main(null);
                    break;
                case 5:
                    buscarUsuarioVenda.cliente();
                    buscarUsuarioVenda.funcionario();
                    break;
                case 6:
                    /*Teste do pagamento*/
                    pagamentos.pagamento(100);
                    caixaView.iniciar();
                    break;
                case 0:
                    /*Sair*/
                    em.close();
                    break;
                default:
                    System.out.println("Escolha uma opcao valida!!");
                    main(null);
            }

        } while (op != 0);

    }
}

