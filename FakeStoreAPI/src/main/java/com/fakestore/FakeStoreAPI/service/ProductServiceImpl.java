package com.fakestore.FakeStoreAPI.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fakestore.FakeStoreAPI.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private RestTemplate restTemplate;

    private String baseURL = "https://fakestoreapi.com/products";

    @Override
    public List<Product> getProductsByCategory(String category) {

        String URL = baseURL+"/category/"+category;

        Product[] products = restTemplate.getForObject(URL, Product[].class);

        return Arrays.asList(products);

    }

    @Override
    public Product addProduct(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
    }
    
}
