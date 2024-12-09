package com.fakestore.FakeStoreAPI.service;

import java.util.List;

import com.fakestore.FakeStoreAPI.entity.Product;

public interface ProductService {

    List<Product> getProductsByCategory(String category);

    Product addProduct(Product product);

}
