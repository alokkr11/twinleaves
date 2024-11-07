package com.twinleaves.service;

import java.util.List;

import com.twinleaves.dto.BatchResponseDto;
import com.twinleaves.entity.Batch;

public interface BatchService {

    BatchResponseDto createBatch(Batch batch);

    BatchResponseDto getBatchById(Long id);

    List<BatchResponseDto> getAllBatches();

    List<BatchResponseDto> getLatestBatchWithNonPositiveQuantity();

}
