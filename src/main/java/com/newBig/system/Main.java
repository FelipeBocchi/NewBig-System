package com.newBig.system;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import com.newBig.system.config.FlyWayConfig;
import com.newBig.system.controller.HelpController;
import com.newBig.system.controller.batch.BatchControllerInterface;
import com.newBig.system.controller.batch.impl.BatchControllerImpl;
import com.newBig.system.controller.product.ProductControllerInterface;
import com.newBig.system.controller.product.impl.ProductControllerImpl;
import com.newBig.system.controller.usuario.UsuarioControllerInterface;
import com.newBig.system.controller.usuario.impl.UsuarioControllerImpl;
import com.newBig.system.model.repository.*;
import com.newBig.system.model.repository.batch.impl.BatchRepository;
import com.newBig.system.model.repository.product.impl.ProductRepository;
import com.newBig.system.model.repository.sale.impl.SaleRepository;
import com.newBig.system.model.repository.saleMovement.impl.SalesMovementRepository;
import com.newBig.system.model.repository.stockMovement.impl.StockMovementRepository;
import com.newBig.system.model.service.*;
import com.newBig.system.model.service.batch.impl.BatchService;
import com.newBig.system.model.service.product.impl.ProductService;
import com.newBig.system.model.service.sale.AddItemToSale;
import com.newBig.system.model.service.sale.OpenSale;
import com.newBig.system.model.service.sale.SaleService;
import com.newBig.system.model.service.usuario.AtualizarUsuarioServiceItf;
import com.newBig.system.model.service.usuario.CadastroUsuarioServiceItf;
import com.newBig.system.model.service.usuario.DadosUsuarioServiceItf;
import com.newBig.system.model.service.usuario.DeletarUsuarioServiceItf;
import com.newBig.system.model.service.usuario.impl.AtualizarUsuario;
import com.newBig.system.model.service.usuario.impl.CadastroUsuario;
import com.newBig.system.model.service.usuario.impl.DadosUsuario;
import com.newBig.system.model.service.usuario.impl.DeletarUsuario;
import jakarta.persistence.EntityManager;

import com.newBig.system.view.login.TelaLogin;

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
        AtualizarUsuarioServiceItf atualizarUsuario = new AtualizarUsuario();
        CadastroUsuarioServiceItf cadastroUsuario = new CadastroUsuario();
        DadosUsuarioServiceItf dadosUsuario = new DadosUsuario();
        DeletarUsuarioServiceItf deletarUsuario = new DeletarUsuario();

        //teste controller
        BatchControllerInterface batchController = new BatchControllerImpl(batchService, productService);
        ProductControllerInterface productController = new ProductControllerImpl(productService);
        UsuarioControllerInterface usuarioController = new UsuarioControllerImpl(atualizarUsuario, cadastroUsuario, dadosUsuario, deletarUsuario);
        HelpController helpController = new HelpController(batchController, productController, usuarioController);

        AddItemToSale addItemToSale = new AddItemToSale(saleRepository, batchRepository, stockMovementRepository, salesMovementRepository);
        OpenSale openSale = new OpenSale(saleRepository, addItemToSale, clienteRepo, funcionarioRepo);

        HelpService helpService = new HelpService(productService, batchService, saleService, openSale, addItemToSale, saleMovementService);

        TelaLogin telaLogin = new TelaLogin(helpService, batchController, helpController
        );
        telaLogin.setVisible(true);

    }
}

