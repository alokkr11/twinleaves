package com.twinleaves.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BatchResponseDto {

    private Long batchId;
    private Long gtinId;
    private int mrp;
    private int sp;
    private int purchasePrice;
    private int availableQuantity;
    private LocalDateTime updatedOn;
    
}
