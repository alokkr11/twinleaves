package com.twinleaves.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BatchDto {

    private Long batchId;
    private Long gtinId;
    private int availableQuantity;
    
}
