package com.example.testbackend.service.impl;

import com.example.testbackend.model.ProductType;
import com.example.testbackend.repository.IProductTypeRepository;
import com.example.testbackend.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    private IProductTypeRepository iProductTypeRepository;

    @Override
    public List<ProductType> getAll() {
        return iProductTypeRepository.getAll();
    }
}
