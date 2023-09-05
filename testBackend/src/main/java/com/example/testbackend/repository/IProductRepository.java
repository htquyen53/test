package com.example.testbackend.repository;

import com.example.testbackend.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IProductRepository extends JpaRepository<Product, Integer> {
//    @Query(value = "select * from product where name like :searchName", nativeQuery = true)
    Page<Product> findAllByNameContaining(Pageable pageable, @Param(value = "searchName") String name);
    @Modifying
    @Transactional
    @Query(value = "insert into products (input_date, name, quantity, id_type ) values (:input_date, :name, :quantity, :id_type)",nativeQuery = true)
    void addProduct(@Param(value = "input_date") String inputDate,
                    @Param(value = "name") String name,@Param(value = "quantity") Integer quantity,
                    @Param(value = "id_type") Integer idType);
    void deleteById(Integer id);
    Product findAllById(Integer id);

}
