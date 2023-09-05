package com.example.testbackend.service;

import com.example.testbackend.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(Pageable pageable, String name);
    void addProduct(Product product);
    void deleteProduct(Integer id);
}
