package com.newBig.system.controller;

import com.newBig.system.controller.batch.BatchControllerInterface;

public class HelpController {

    private BatchControllerInterface batchController;

    public HelpController(BatchControllerInterface batchController) {
        this.batchController = batchController;
    }

    public HelpController() {
    }

    public BatchControllerInterface getBatchController() {
        return batchController;
    }
}
