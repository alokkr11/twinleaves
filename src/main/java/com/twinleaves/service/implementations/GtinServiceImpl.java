package com.twinleaves.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twinleaves.entity.Gtin;
import com.twinleaves.exception.ResourceNotFoundException;
import com.twinleaves.repository.GtinRepository;
import com.twinleaves.service.GtinService;

@Service
public class GtinServiceImpl implements GtinService {

    @Autowired
    private GtinRepository gtinRepository;

    @Override
    public Gtin createGtin(Gtin gtin) {
        return gtinRepository.save(gtin);
    }

    @Override
    public Gtin getGtinById(Long id) {
        return gtinRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GTIN not found with id " + id));
    }

    @Override
    public List<Gtin> getAllGtins() {
        return gtinRepository.findAll();
    }

    @Override
    public List<Gtin> getGtinsWithPositiveQuantity() {
        return gtinRepository.findGtinsWithPositiveQuantity();
    }

}
