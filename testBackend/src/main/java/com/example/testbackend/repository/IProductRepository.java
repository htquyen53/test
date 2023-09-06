package com.example.testbackend.repository;

import com.example.testbackend.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product where name like :searchName", nativeQuery = true)
    Page<Product> findAllByNameContaining(Pageable pageable, @Param(value = "searchName") String name);
    @Modifying
    @Transactional
    @Query(value = "insert into product (input_date, name, quantity, id_type ) values (:input_date, :name, :quantity, :id_type)",nativeQuery = true)
    void addProduct(@Param(value = "input_date") Date inputDate,
                    @Param(value = "name") String name,
                    @Param(value = "quantity") Integer quantity,
                    @Param(value = "id_type") Integer idType);

    @Modifying
    @Transactional
    @Query(value = "update product set name = :name, quantity = :quantity, id_type = :idType, input_date = :inputDate " +
            "where id = :id ", nativeQuery = true)
    void updateProduct(@Param(value = "id") Integer id,
                       @Param(value = "name") String name,
                       @Param(value = "quantity") Integer quantity,
                       @Param(value = "idType")Integer idType,
                       @Param(value = "inputDate")Date inputDate);
   @Modifying
   @Transactional
   @Query(value = "delete from product where id = :id ", nativeQuery = true)
    void deleteById(@Param(value = "id") Integer id);
    Product findAllById(Integer id);

}
