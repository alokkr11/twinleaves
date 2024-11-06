package com.twinleaves.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twinleaves.entity.Product;
import com.twinleaves.repository.ProductRepository;
import com.twinleaves.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product addProduct(Product p) {
        // TODO Auto-generated method stub
        return productRepository.save(p);
    }
    
}
