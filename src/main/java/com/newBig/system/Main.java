package com.newBig.system;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import com.newBig.system.config.FlyWayConfig;
import com.newBig.system.repository.BatchRepository;
import com.newBig.system.repository.CustomizerFactory;
import com.newBig.system.repository.ProductRepository;
import com.newBig.system.repository.StockMovementRepository;
import com.newBig.system.service.BatchService;
import com.newBig.system.service.HelpService;
import com.newBig.system.service.ProductService;
import jakarta.persistence.EntityManager;

import com.newBig.system.service.Caixa;
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

        //  = service
        ProductService productService = new ProductService(productRepository);
        BatchService batchService = new BatchService(batchRepository, productRepository,stockMovementRepository);

        HelpService helpService = new HelpService(productService, batchService);

        TelaLogin telaLogin = new TelaLogin(helpService);
        telaLogin.setVisible(true);

    }
}

