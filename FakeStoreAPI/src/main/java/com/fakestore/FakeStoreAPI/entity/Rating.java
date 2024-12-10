package com.fakestore.FakeStoreAPI.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class Rating {
    @Min(value = 1, message = "Rate should not be less than 1")
    @Max(value = 5, message = "Rate should not be greater than 5")
    private Double rate;
    @Min(value = 1, message = "There should be at least one rating")
    private Integer count;

    public Rating() {
        this.count = 0;
        this.rate = 0.0;
    }

    
}
