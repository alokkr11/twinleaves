package com.twinleaves.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twinleaves.dto.BatchResponseDto;
import com.twinleaves.entity.Batch;
import com.twinleaves.exception.ResourceNotFoundException;
import com.twinleaves.repository.BatchRepository;
import com.twinleaves.service.BatchService;

@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchRepository batchRepository;

    @Override
    public BatchResponseDto createBatch(Batch batch) {
        Batch b = batchRepository.save(batch);
        return new BatchResponseDto(b.getId(), b.getGtin().getId(), b.getMrp(), b.getSp(), b.getPurchasePrice(),
                b.getAvailableQuantity(), b.getUpdatedOn());
    }

    @Override
    public BatchResponseDto getBatchById(Long id) {
        Batch b = batchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Batch not found with id " + id));
        return new BatchResponseDto(b.getId(), b.getGtin().getId(), b.getMrp(), b.getSp(), b.getPurchasePrice(),
                b.getAvailableQuantity(), b.getUpdatedOn());

    }

    @Override
    public List<BatchResponseDto> getAllBatches() {
        List<Batch> batches = batchRepository.findAll();
        return batches.stream()
                .map(batch -> new BatchResponseDto(
                        batch.getId(),
                        batch.getGtin().getId(),
                        batch.getMrp(),
                        batch.getSp(),
                        batch.getPurchasePrice(),
                        batch.getAvailableQuantity(),
                        batch.getUpdatedOn()))
                .collect(Collectors.toList());
    }

    @Override
    public List<BatchResponseDto> getLatestBatchWithNonPositiveQuantity() {
        List<Batch> latestNonPositiveBatches = batchRepository.findLatestBatchWithNonPositiveQuantity();

        // Convert each Batch entity to BatchDto
        return latestNonPositiveBatches.stream()
                .map(batch -> new BatchResponseDto(
                        batch.getId(),
                        batch.getGtin().getId(),
                        batch.getMrp(),
                        batch.getSp(),
                        batch.getPurchasePrice(),
                        batch.getAvailableQuantity(),
                        batch.getUpdatedOn()))
                .collect(Collectors.toList());
    }

}
