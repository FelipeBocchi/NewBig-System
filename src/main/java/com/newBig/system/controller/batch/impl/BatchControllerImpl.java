package com.newBig.system.controller.batch.impl;

import com.newBig.system.controller.batch.BatchControllerInterface;
import com.newBig.system.controller.batch.dto.BatchResponse;
import com.newBig.system.model.repository.batch.BatchInterface;
import com.newBig.system.model.service.batch.BatchServiceInterface;

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
}
