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

import com.twinleaves.entity.Gtin;
import com.twinleaves.exception.ResourceNotFoundException;
import com.twinleaves.service.GtinService;

@RestController
@RequestMapping("/twinleaves/gtins")
public class GtinController {

    @Autowired
    private GtinService gtinService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getGtinById(@PathVariable Long id) {
        try {
            Gtin gtin = gtinService.getGtinById(id);
            return new ResponseEntity<>(gtin, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>("GTIN not found with id: " + id, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createGtin(@RequestBody Gtin gtin) {
        Gtin createdGtin = gtinService.createGtin(gtin);
        return new ResponseEntity<>(createdGtin, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllGtins() {
        List<Gtin> gtins = gtinService.getAllGtins();
        return new ResponseEntity<>(gtins, HttpStatus.OK);
    }

    @GetMapping("/positive-quantity")
    public ResponseEntity<?> getGtinsWithPositiveQuantity() {
        List<Gtin> gtinsWithPositiveQuantity = gtinService.getGtinsWithPositiveQuantity();
        return new ResponseEntity<>(gtinsWithPositiveQuantity, HttpStatus.OK);
    }

}
