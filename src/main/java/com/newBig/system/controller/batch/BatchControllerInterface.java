package com.newBig.system.controller.batch;

import com.newBig.system.controller.batch.dto.BatchSendDto;
import com.newBig.system.controller.batch.dto.BatchSummaryDto;

import java.util.List;

public interface BatchControllerInterface {

    void arrivalBatch(BatchSendDto batchSendDto);

    List<BatchSummaryDto> listAll();

    void deleteBatch(Long id);

}
