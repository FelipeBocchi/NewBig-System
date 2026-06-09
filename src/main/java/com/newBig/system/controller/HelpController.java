package com.newBig.system.controller;

import com.newBig.system.controller.batch.BatchControllerInterface;
import com.newBig.system.controller.product.ProductControllerInterface;

public class HelpController {

    private BatchControllerInterface batchController;
    private ProductControllerInterface productController;

    public HelpController(BatchControllerInterface batchController, ProductControllerInterface productController) {
        this.batchController = batchController;
        this.productController = productController;
    }

    public HelpController() {
    }

    public BatchControllerInterface getBatchController() {
        return batchController;
    }

    public ProductControllerInterface getProductController() {
        return productController;
    }

}
