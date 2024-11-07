package com.twinleaves.service;

import java.util.List;

import com.twinleaves.dto.GtinResponseDto;
import com.twinleaves.entity.Gtin;

public interface GtinService {

    GtinResponseDto createGtin(Gtin gtin);

    GtinResponseDto getGtinById(Long id);

    List<GtinResponseDto> getAllGtins();

    List<GtinResponseDto> getGtinsWithPositiveQuantity();

}
