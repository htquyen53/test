package com.example.testbackend.model;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Date inputDate;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name="id_Type", referencedColumnName = "idType")
    private ProductType productType;
    public Product(){
    }

    public Product(Integer id, String name, Date inputDate, Integer quantity) {
        this.id = id;
        this.name = name;
        this.inputDate = inputDate;
        this.quantity = quantity;
    }

    public Product(Integer id, String name, Date inputDate, Integer quantity, ProductType productType) {
        this.id = id;
        this.name = name;
        this.inputDate = inputDate;
        this.quantity = quantity;
        this.productType = productType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
