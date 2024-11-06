package com.twinleaves.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twinleaves.entity.Product;
import com.twinleaves.service.ProductService;

@RestController
@RequestMapping("/twinleaves/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/")
    ResponseEntity<Product> addProduct(@RequestBody Product p){
        // Product p =productService.addProduct(p);
        return ResponseEntity.ok(productService.addProduct(p));
    }

}
