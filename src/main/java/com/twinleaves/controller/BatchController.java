package com.twinleaves.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twinleaves.dto.BatchResponseDto;
import com.twinleaves.entity.Batch;
import com.twinleaves.exception.ResourceNotFoundException;
import com.twinleaves.service.BatchService;

@RestController
@RequestMapping("/twinleaves/batches")
public class BatchController {

    @Autowired
    private BatchService batchService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getBatchById(@PathVariable Long id) {
        try {
            BatchResponseDto batch = batchService.getBatchById(id);
            return new ResponseEntity<>(batch, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>("Batch not found with id: " + id, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createBatch(@RequestBody Batch batch) {
        BatchResponseDto createdBatch = batchService.createBatch(batch);
        return new ResponseEntity<>(createdBatch, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllBatches() {
        List<BatchResponseDto> batches = batchService.getAllBatches();
        return new ResponseEntity<>(batches, HttpStatus.OK);
    }

    @GetMapping("/latest-non-positive")
    public ResponseEntity<?> getLatestBatchWithNonPositiveQuantity() {
        List<BatchResponseDto> latestNonPositiveBatches = batchService.getLatestBatchWithNonPositiveQuantity();
        return new ResponseEntity<>(latestNonPositiveBatches, HttpStatus.OK);
    }

}
