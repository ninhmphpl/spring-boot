package com.example.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.model.Product;
import com.example.boot.service.IProductService;


@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService ;

    @GetMapping
    public ResponseEntity<?> findAllProduct(){
        List<Product> list =  productService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id){
        productService.findById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        Product productResult = productService.save(product);
        return new ResponseEntity<>(productResult , HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        Product productResult = productService.save(product);
        return new ResponseEntity<>(productResult , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> addProduct(@PathVariable Long id){
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
