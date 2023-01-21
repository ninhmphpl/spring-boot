package com.example.boot.service;

import java.util.List;
import java.util.Optional;

public interface CrudRepository <T, ID>{
    List<T> findAll();
    Optional<T> findById(ID id);
    T save(T t);
    void deleteById(ID id);
}
