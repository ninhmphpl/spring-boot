package com.example.boot.controller;

import com.example.boot.model.ProductDetail;
import com.example.boot.model.ProductLite;
import com.example.boot.service.IProductDetailService;
import com.example.boot.service.IProductLiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductLiteService productLiteService;
    @Autowired
    private IProductDetailService productDetailService;

    @GetMapping("/lites")
    public ResponseEntity<List<ProductLite>> findAllProductLite(){
        List<ProductLite> productLites = productLiteService.findAll();
        if(productLites.size() == 0 ){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(productLites, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<ProductDetail> findProductDetailById(@PathVariable Long id){
        Optional<ProductDetail> productDetail = productDetailService.findById(id);
        return productDetail.map(detail -> new ResponseEntity<>(detail, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_GATEWAY));
    }

    @PostMapping("/detail")
    public ResponseEntity<ProductDetail> createProductDetail(@RequestBody ProductDetail productDetail){

        ProductDetail detail =  productDetailService.save(productDetail);
        return new ResponseEntity<>(detail, HttpStatus.OK);

    }





}