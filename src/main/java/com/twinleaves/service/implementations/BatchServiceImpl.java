package com.twinleaves.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twinleaves.dto.BatchDto;
import com.twinleaves.entity.Batch;
import com.twinleaves.exception.ResourceNotFoundException;
import com.twinleaves.repository.BatchRepository;
import com.twinleaves.service.BatchService;

@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchRepository batchRepository;

    @Override
    public Batch createBatch(Batch batch) {
        return batchRepository.save(batch);
    }

    @Override
    public Batch getBatchById(Long id) {
        return batchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Batch not found with id " + id));
    }

    @Override
    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }

    @Override
    public List<BatchDto> getLatestBatchWithNonPositiveQuantity() {
        List<Batch> latestNonPositiveBatches = batchRepository.findLatestBatchWithNonPositiveQuantity();

        // Convert each Batch entity to BatchDto
        return latestNonPositiveBatches.stream()
                .map(batch -> new BatchDto(
                        batch.getId(),
                        batch.getGtin().getId(),
                        batch.getAvailableQuantity()))
                .collect(Collectors.toList());
    }

}
