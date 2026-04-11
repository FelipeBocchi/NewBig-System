package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.Batch;
import com.newBig.system.domain.model.Product;
import com.newBig.system.domain.model.Stock;
import com.newBig.system.domain.repository.ProductRepository;
import com.newBig.system.domain.repository.StockRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FilterBatchByStock {

    private StockRepository repository;
    private ProductRepository productRepository;

    public FilterBatchByStock(StockRepository repository, ProductRepository productRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
    }

    public List<Batch> execute() {

        Stock stock = new Stock(repository.findAll());
        List<Batch> list = stock.findAll();
        List<Batch> newList = new ArrayList<>();

        for (Batch b : list) {
            Product product = productRepository.searchById(b.getProduct().getId());

            if (stock.isLowStock(product.getId(), product.getMinimumStock()) || stock.isOutOfStock(product.getId()))
                newList.add(b);
        }

        //  = Vai pegar a nova lista de lotes com estoque baixo ou zerados e ordenar eles, após retorna a lista ordenada.
        return newList.stream().sorted(Comparator.comparing(Batch::getAmount)).toList();
    }
}
