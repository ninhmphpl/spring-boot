package com.example.boot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.boot.model.ProductLite;

public interface IProductLiteService extends CrudService< ProductLite , Long > {
    Page<ProductLite> findAllPage(Pageable pageable);
}
