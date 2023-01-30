package com.example.boot.repository;

import com.example.boot.model.ProductLite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLiteRepository extends JpaRepository< ProductLite , Long > {
}
