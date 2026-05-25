package com.newBig.system.service;

import com.newBig.system.model.SalesMovement;

public class HelpService {

    /*
            Essa class foi criada com o objetivode instacioar todosos services, pois, o
            View não pode receber o end point diretamente
     */

    private ProductService productService;
    private BatchService batchService;
    private SaleService saleService;
    private SaleMovementService salesMovement;
    private OpenSale openSale;
    private AddItemToSale addItemToSale;

    public HelpService() { }

    public HelpService(ProductService productService, BatchService batchService, SaleService saleService, OpenSale openSale, AddItemToSale addItemToSale, SaleMovementService salesMovement) {
        this.productService = productService;
        this.batchService = batchService;
        this.saleService = saleService;
        this.openSale = openSale;
        this.addItemToSale = addItemToSale;
        this.salesMovement = salesMovement;
    }

    public HelpService(ProductService productService, BatchService batchService) {
    }

    //  =   Gettings

    public ProductService getProductService() {
        return productService;
    }

    public BatchService getBatchService() {
        return batchService;
    }

    public SaleService getSaleService() {
        return saleService;
    }

    public OpenSale getOpenSale() {
        return openSale;
    }

    public AddItemToSale getAddItemToSale() {
        return addItemToSale;
    }

    public SaleMovementService getSalesMovement() {
        return salesMovement;
    }
}
