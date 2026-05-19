package com.newBig.system;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import com.newBig.system.config.FlyWayConfig;
import com.newBig.system.repository.*;
import com.newBig.system.service.*;
import jakarta.persistence.EntityManager;

import com.newBig.system.view.TelaLogin;

public class Main {

    public static void main(String[] args) {
        FlyWayConfig.migrate();
        //  = Conecção com o banco e inicialização
        EntityManager em = CustomizerFactory.getEntityManager();

        //  = repository
        ProductRepository productRepository = new ProductRepository(em);
        BatchRepository batchRepository = new BatchRepository(em);
        StockMovementRepository stockMovementRepository = new StockMovementRepository(em);
        SaleRepository saleRepository = new SaleRepository(em);
        SalesMovementRepository salesMovementRepository = new SalesMovementRepository(em);
        FuncionarioRepo funcionarioRepo = new FuncionarioRepo(em);
        ClienteRepo clienteRepo = new ClienteRepo(em);

        //  = service
        ProductService productService = new ProductService(productRepository);
        BatchService batchService = new BatchService(batchRepository, productRepository,stockMovementRepository);
        SaleService saleService = new SaleService(saleRepository);
        SaleMovementService saleMovementService = new SaleMovementService(salesMovementRepository);

        AddItemToSale addItemToSale = new AddItemToSale(saleRepository, batchRepository, stockMovementRepository, salesMovementRepository);
        OpenSale openSale = new OpenSale(saleRepository, addItemToSale, clienteRepo, funcionarioRepo);

        HelpService helpService = new HelpService(productService, batchService, saleService, openSale, addItemToSale, saleMovementService);

        TelaLogin telaLogin = new TelaLogin(helpService);
        telaLogin.setVisible(true);

    }
}

