package com.newBig.system.controller;

import com.newBig.system.controller.batch.BatchControllerInterface;
import com.newBig.system.controller.product.ProductControllerInterface;
import com.newBig.system.controller.usuario.UsuarioControllerInterface;

public class HelpController {

    private BatchControllerInterface batchController;
    private ProductControllerInterface productController;
    private UsuarioControllerInterface usuarioController;

    public HelpController(BatchControllerInterface batchController, ProductControllerInterface productController, UsuarioControllerInterface usuarioController) {
        this.batchController = batchController;
        this.productController = productController;
        this.usuarioController = usuarioController;
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
}
