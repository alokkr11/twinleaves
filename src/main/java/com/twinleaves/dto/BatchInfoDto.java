package com.twinleaves.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BatchInfoDto {

    private Long batchId;
    private int availableQuantity;

}
