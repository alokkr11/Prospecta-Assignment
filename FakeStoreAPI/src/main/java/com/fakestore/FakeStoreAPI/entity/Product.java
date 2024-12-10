package com.fakestore.FakeStoreAPI.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Product {

    private Integer id;
    @NotNull(message = "title should not be null")
    private String title;
    @NotNull(message = "price should not be null")
    private Double price;
    @NotNull(message = "description should not be null")
    private String description;
    @NotNull(message = "category should not be null")
    private String category;
    @NotNull(message = "image should not be null")
    private String image;
    @Valid
    private Rating rating;

}
