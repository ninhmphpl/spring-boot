package com.example.boot.repository;

import com.example.boot.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail,Long> {
    @Query(value = "select max(id) from product;", nativeQuery = true)
    Long getID();
}
