package com.newBig.system.service;

import com.newBig.system.model.Sale;
import com.newBig.system.repository.SaleInterface;
import com.newBig.system.repository.SaleRepository;

import java.util.List;

public class SaleService {

    private SaleInterface saleRepository;

    public SaleService(SaleInterface repository) {
        this.saleRepository = repository;
    }

    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

}
