package com.example.boot.service;

import com.example.boot.model.ProductLite;
import org.springframework.stereotype.Service;

@Service
public interface IProductLiteService extends CrudService< ProductLite , Long > {
}
