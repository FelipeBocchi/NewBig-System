package com.newBig.system.controller.batch;

import com.newBig.system.controller.batch.dto.BatchResponse;
import com.newBig.system.controller.batch.dto.BatchSummaryDto;

import java.util.List;

public interface BatchControllerInterface {

    BatchResponse retornaPoduto(Long id);

    List<BatchSummaryDto> listAll();

    void deleteBatch(Long id);

}
