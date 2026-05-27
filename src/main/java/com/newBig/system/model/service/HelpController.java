package com.newBig.system.model.service;

import com.newBig.system.controller.batch.BatchControllerInterface;

public class HelpController {

    private final BatchControllerInterface batchController;

    public HelpController(BatchControllerInterface batchController) {
        this.batchController = batchController;
    }

    public BatchControllerInterface getBatchController() {
        return batchController;
    }
}
