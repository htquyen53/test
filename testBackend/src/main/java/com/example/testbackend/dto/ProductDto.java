package com.example.testbackend.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

public class ProductDto implements Validator {
    private String name;
    private Date inputDate;
    private Integer quantity;

    public ProductDto() {
    }

    public ProductDto(String name, Date inputDate, Integer quantity) {
        this.name = name;
        this.inputDate = inputDate;
        this.quantity = quantity;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        if(productDto.getName().trim().equals("")) {
            errors.rejectValue("name",null,"Không được để trống tên");
        } else if (productDto.getName().length()>500) {
            errors.rejectValue("name",null,"Tên không được vượt quá 500 ký tự");
        }
        if(productDto.getInputDate().equals("")) {
            errors.rejectValue("inputDate", null, "Không được để trống ngày nhập");
        }
        if(productDto.getQuantity()<0) {
            errors.rejectValue("quantity",null, "Số lượng không được là số âm");
        }
    }
}
