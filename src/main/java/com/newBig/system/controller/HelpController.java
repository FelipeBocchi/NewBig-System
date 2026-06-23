package com.newBig.system.controller;

import com.newBig.system.controller.batch.BatchControllerInterface;
import com.newBig.system.controller.caixa.CaixaControllerInterface;
import com.newBig.system.controller.product.ProductControllerInterface;
import com.newBig.system.controller.sale.SaleControllerInterface;
import com.newBig.system.controller.usuario.UsuarioControllerInterface;
import com.newBig.system.model.service.sale.SaleService;

public class HelpController {

    private BatchControllerInterface batchController;
    private ProductControllerInterface productController;
    private UsuarioControllerInterface usuarioController;
    private SaleControllerInterface saleController;
    private CaixaControllerInterface caixaController;

    public HelpController(BatchControllerInterface batchController, ProductControllerInterface productController, UsuarioControllerInterface usuarioController, SaleControllerInterface saleController, CaixaControllerInterface caixaController) {
        this.batchController = batchController;
        this.productController = productController;
        this.usuarioController = usuarioController;
        this.saleController = saleController;
        this.caixaController = caixaController;
    }

    public HelpController() {
    }

    public BatchControllerInterface getBatchController() {
        return batchController;
    }

    public ProductControllerInterface getProductController() {
        return productController;
    }

    public UsuarioControllerInterface getUsuarioController() {
        return usuarioController;
    }

    public SaleControllerInterface getSaleController() {
        return saleController;
    }

    public CaixaControllerInterface getCaixaController() {
        return caixaController;
    }
}
