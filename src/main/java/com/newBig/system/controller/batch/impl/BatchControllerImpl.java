package com.newBig.system.controller.batch.impl;

import com.newBig.system.controller.batch.BatchControllerInterface;
import com.newBig.system.controller.batch.dto.BatchResponse;
import com.newBig.system.controller.batch.dto.BatchSummaryDto;
import com.newBig.system.model.entity.Batch;
import com.newBig.system.model.service.batch.BatchServiceInterface;

import java.util.ArrayList;
import java.util.List;

public class BatchControllerImpl implements BatchControllerInterface {

    private BatchServiceInterface batchService;

    public BatchControllerImpl(BatchServiceInterface batchService) {
        this.batchService = batchService;
    }

    public BatchControllerImpl() {
    }

    @Override
    public BatchResponse retornaPoduto(Long id) {

        var batch = batchService.findByProduct(id);
        return new BatchResponse(batch.get(0).getProduct().getProductName(), batch.get(0).getAmount());

    }

    @Override
    public List<BatchSummaryDto> listAll() {

        List<Batch> batchList = batchService.findAll();
        List<BatchSummaryDto> summaryDtoList = new ArrayList<>();

        for (Batch b : batchList) {
            summaryDtoList.add(new BatchSummaryDto(b.getId(), b.getSeries(), b.getProduct().getProductName(), b.getAmount(), b.getValidity()));
        }

        return summaryDtoList;
    }

    @Override
    public void deleteBatch(Long id) {

        Batch batch = batchService.searchById(id);

        if (batch.getAmount() != 0) {
            throw new IllegalStateException("Esse lote não está zerado! Logo, não pode ser deletado.");
        }

        batchService.deleteZero(batch);

    }
}
