package com.twinleaves.service;

import java.util.List;

import com.twinleaves.entity.Gtin;

public interface GtinService {

    Gtin createGtin(Gtin gtin);

    Gtin getGtinById(Long id);

    List<Gtin> getAllGtins();

    List<Gtin> getGtinsWithPositiveQuantity();

}
