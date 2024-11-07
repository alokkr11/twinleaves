package com.twinleaves.service;

import java.util.List;

import com.twinleaves.dto.BatchDto;
import com.twinleaves.entity.Batch;

public interface BatchService {

    Batch createBatch(Batch batch);

    Batch getBatchById(Long id);

    List<Batch> getAllBatches();

    List<BatchDto> getLatestBatchWithNonPositiveQuantity();

}
