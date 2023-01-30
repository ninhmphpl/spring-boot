package com.example.boot.service.impl;

import com.example.boot.model.ProductDetail;
import com.example.boot.repository.ProductDetailRepository;
import com.example.boot.service.IProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductDetailService implements IProductDetailService {

    @Autowired
    private ProductDetailRepository repository;
    @Override
    public List<ProductDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ProductDetail> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ProductDetail save(ProductDetail productDetail) {

        if(productDetail.getImgs().size() > 0){
            productDetail.setImg(productDetail.getImgs().get(0).getUrl());
        }

        return repository.save(productDetail);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
