package com.fakestore.FakeStoreAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fakestore.FakeStoreAPI.entity.Product;
import com.fakestore.FakeStoreAPI.exception.ProductNotFoundException;
import com.fakestore.FakeStoreAPI.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/store-api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category) {
        List<Product> products = productService.getProductsByCategory(category);
        if(products.size()==0){
            throw new ProductNotFoundException("No products found for category: " + category);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product){
        try {
            return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.CREATED); 
        } catch (Exception e) {
            throw new RuntimeException(e);
        } 
    }

}
