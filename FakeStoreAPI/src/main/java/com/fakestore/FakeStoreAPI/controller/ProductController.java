package com.fakestore.FakeStoreAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fakestore.FakeStoreAPI.entity.Product;
import com.fakestore.FakeStoreAPI.service.ProductService;

@RestController
@RequestMapping("/store-api/v1")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category){
        return new ResponseEntity<>(productService.getProductsByCategory(category),HttpStatus.OK);
    }

}
