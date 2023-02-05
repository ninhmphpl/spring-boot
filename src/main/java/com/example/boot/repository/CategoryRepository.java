package com.example.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.boot.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
