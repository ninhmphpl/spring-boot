package com.example.boot.service.impl;

import com.example.boot.model.ProductLite;
import com.example.boot.repository.ProductLiteRepository;
import com.example.boot.service.IProductLiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductLiteService implements IProductLiteService {

    @Autowired
    private ProductLiteRepository repository;

    @Override
    public List<ProductLite> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ProductLite> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ProductLite save(ProductLite productLite) {
        return repository.save( productLite );
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
