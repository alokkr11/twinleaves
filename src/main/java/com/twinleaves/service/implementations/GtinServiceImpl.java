package com.twinleaves.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twinleaves.dto.BatchInfoDto;
import com.twinleaves.dto.GtinResponseDto;
import com.twinleaves.entity.Gtin;
import com.twinleaves.exception.ResourceNotFoundException;
import com.twinleaves.repository.GtinRepository;
import com.twinleaves.service.GtinService;

@Service
public class GtinServiceImpl implements GtinService {

    @Autowired
    private GtinRepository gtinRepository;

    @Override
    public GtinResponseDto createGtin(Gtin gtin) {
        Gtin g = gtinRepository.save(gtin);
        
        return new GtinResponseDto(g.getId(), g.getGtin(), g.getProduct().getId(), g.getBatches().stream()
                .filter(batch -> batch.getAvailableQuantity() > 0)
                .map(batch -> new BatchInfoDto(
                        batch.getId(),
                        batch.getAvailableQuantity()))
                .collect(Collectors.toList()));
    }

    @Override
    public GtinResponseDto getGtinById(Long id) {
        Gtin g = gtinRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GTIN not found with id " + id));

        return new GtinResponseDto(g.getId(), g.getGtin(), g.getProduct().getId(), g.getBatches().stream()
                .filter(batch -> batch.getAvailableQuantity() > 0)
                .map(batch -> new BatchInfoDto(
                        batch.getId(),
                        batch.getAvailableQuantity()))
                .collect(Collectors.toList()));
    }

    @Override
    public List<GtinResponseDto> getAllGtins() {
        List<Gtin> gtins = gtinRepository.findAll();
        return gtins.stream()
                .map(gtin -> new GtinResponseDto(
                        gtin.getId(),
                        gtin.getGtin(),
                        gtin.getProduct().getId(),
                        gtin.getBatches().stream()
                                .filter(batch -> batch.getAvailableQuantity() > 0)
                                .map(batch -> new BatchInfoDto(
                                        batch.getId(),
                                        batch.getAvailableQuantity()))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @Override
    public List<GtinResponseDto> getGtinsWithPositiveQuantity() {
        List<Gtin> gtinsWithPositiveQuantity = gtinRepository.findGtinsWithPositiveQuantity();
        return gtinsWithPositiveQuantity.stream()
                .map(gtin -> new GtinResponseDto(
                        gtin.getId(),
                        gtin.getGtin(),
                        gtin.getProduct().getId(),
                        gtin.getBatches().stream()
                                .filter(batch -> batch.getAvailableQuantity() > 0)
                                .map(batch -> new BatchInfoDto(
                                        batch.getId(),
                                        batch.getAvailableQuantity()))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

}
