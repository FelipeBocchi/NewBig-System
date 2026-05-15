package com.newBig.system.service;

public class HelpService {

    /*
            Essa class foi criada com o objetivode instacioar todosos services, pois, o
            View não pode receber o end point diretamente
     */

    private ProductService productService;
    private BatchService batchService;

    public HelpService() { }

    public HelpService(ProductService productService, BatchService batchService) {
        this.productService = productService;
        this.batchService = batchService;
    }

    //  =   Gettings

    public ProductService getProductService() {
        return productService;
    }

    public BatchService getBatchService() {
        return batchService;
    }
}
