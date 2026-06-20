package com.newBig.system.model.service.sale;

import com.newBig.system.model.entity.Sale;
import com.newBig.system.model.repository.sale.SaleInterface;

import java.util.List;

public class SaleService {

    private SaleInterface saleRepository;

    public SaleService(SaleInterface repository) {
        this.saleRepository = repository;
    }

    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    public Sale editSale(Sale sale) {
        return saleRepository.update(sale);
    }

    public Sale findById(Long id) {
        return saleRepository.searchById(id);
    }

}
