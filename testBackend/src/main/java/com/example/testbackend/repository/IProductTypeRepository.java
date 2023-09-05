package com.example.testbackend.repository;

import com.example.testbackend.model.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductTypeRepository extends JpaRepository<ProductType, Integer> {
    @Query(value = "select * from product_type", nativeQuery = true)
    List<ProductType> getAll();

    @Query(value = "select * from product_type where type_name like :name", nativeQuery = true)
    Page<ProductType> findProductTypeByNameTypeContaining(Pageable pageable, String name);
}
