package com.example.boot.repository;

import com.example.boot.model.ProductLite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLiteRepository extends JpaRepository< ProductLite , Long > {
    @Override
    Page<ProductLite> findAll(Pageable pageable);

}
