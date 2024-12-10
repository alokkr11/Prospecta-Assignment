package com.fakestore.FakeStoreAPI.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fakestore.FakeStoreAPI.entity.Product;
import com.fakestore.FakeStoreAPI.entity.Rating;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private RestTemplate restTemplate;

    private String baseURL = "https://fakestoreapi.com/products";

    @Override
    public List<Product> getProductsByCategory(String category) {

        String URL = baseURL + "/category/" + category;
        Product[] products = restTemplate.getForObject(URL, Product[].class);
        return Arrays.asList(products);

    }

    @Override
    public Product addProduct(Product product) {
        try {
    
            // Make the POST request and get the response
            ResponseEntity<Product> responseEntity = restTemplate.postForEntity(baseURL, product, Product.class);
    
            Product responseProduct = responseEntity.getBody();
    
            // The response may not include the rating, so if the response does not include the rating, set it from the original product
            if (responseProduct != null && product.getRating() != null) {
                responseProduct.setRating(product.getRating());
            }else{
                responseProduct.setRating(new Rating());
            }
    
            return responseProduct;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to add product: " + e.getMessage(), e);
        }

    }

}
