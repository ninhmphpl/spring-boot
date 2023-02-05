package com.example.boot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot.model.Product;
import com.example.boot.repository.ProductRepository;
import com.example.boot.service.IProductService;
@Service
public class ProductService implements IProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        // TODO Auto-generated method stub
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product t) {
        // TODO Auto-generated method stub
        return productRepository.save(t);
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        productRepository.deleteById(id);
    }
    
}
