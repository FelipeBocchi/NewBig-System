package com.newBig.system.controller.sale.impl;

import com.newBig.system.controller.sale.SaleControllerInterface;
import com.newBig.system.controller.sale.dto.SaleMovementDto;
import com.newBig.system.controller.sale.dto.SaleSummaryDto;
import com.newBig.system.model.entity.Sale;
import com.newBig.system.model.entity.SalesMovement;
import com.newBig.system.model.entity.StockMovement;
import com.newBig.system.model.service.SaleMovementService;
import com.newBig.system.model.service.sale.AddItemToSale;
import com.newBig.system.model.service.sale.OpenSale;
import com.newBig.system.model.service.sale.SaleService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SaleControllerImpl implements SaleControllerInterface {

    private SaleService saleService;
    private OpenSale openSale;
    private AddItemToSale addItemToSale;
    private SaleMovementService saleMovementService;

    public SaleControllerImpl(SaleService saleService, OpenSale openSale, AddItemToSale addItemToSale, SaleMovementService saleMovementService) {
        this.saleService = saleService;
        this.openSale = openSale;
        this.addItemToSale = addItemToSale;
        this.saleMovementService = saleMovementService;
    }

    @Override
    public Long openSale() {
        return openSale.execute(1L, 1L, 1001L, 0, "INDEFINIDO");
    }

    @Override
    public void addItensToSale(Long idSale, Long codbarProduct, int quatity) {
        addItemToSale.logic(idSale, codbarProduct, quatity);
    }

    @Override
    public List<SaleSummaryDto> listSale(Long idSale) {

        List<SalesMovement> list = saleMovementService.findById(idSale);
        List<SaleSummaryDto> listDto = new ArrayList<>();

        for (SalesMovement s : list) {
            listDto.add(new SaleSummaryDto(s.getStockMovement().getQuantity(), s.getStockMovement().getIdBatch().getId(), s.getStockMovement().getIdBatch().getProduct().getProductName(), s.getStockMovement().getIdBatch().getProduct().getSalePrice(), s.getId()));
        }

        return listDto;
    }

    @Override
    public void editSalePay(Long idSale, String paymentMethod, String pay, BigDecimal totalSale) {
        Sale sale = saleService.findById(idSale);

        sale.setPaymentMethod(paymentMethod);
        sale.setStatus(pay);
        sale.setTotal(totalSale);

        saleService.editSale(sale);

    }

    @Override
    public BigDecimal valueSale(Long idSale) {
        Sale sale = saleService.findById(idSale);
        return sale.getTotal();
    }

    @Override
    public List<SaleMovementDto> calculateTotalSale(Long idSale) {
        List<SalesMovement> listSaleM = saleMovementService.findById(idSale);
        List<SaleMovementDto> listStockM = new ArrayList<>();
        for (SalesMovement s : listSaleM) {
            StockMovement mov = s.getStockMovement();
            listStockM.add(new SaleMovementDto( mov.getValue(), mov.getQuantity()));
        }

        return listStockM;
    }
}
