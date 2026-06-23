package com.newBig.system.controller.sale;

import com.newBig.system.controller.sale.dto.SaleMovementDto;
import com.newBig.system.controller.sale.dto.SaleSummaryDto;

import java.math.BigDecimal;
import java.util.List;

public interface SaleControllerInterface {

    Long openSale();

    void addItensToSale(Long idSale, Long codbarProduct, int quatity);

    List<SaleSummaryDto> listSale(Long idSale);

    void editSalePay(Long idSale, String paymentMethod, String pay, BigDecimal totalSale);

    BigDecimal valueSale(Long idSale);

    List<SaleMovementDto> calculateTotalSale(Long idSale);

}
