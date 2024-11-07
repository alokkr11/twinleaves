package com.twinleaves.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GtinResponseDto {

    private Long gtinId;
    private String gtin;
    private Long productId;
    private List<BatchInfoDto> batches;

}
