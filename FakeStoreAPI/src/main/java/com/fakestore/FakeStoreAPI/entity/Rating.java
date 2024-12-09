package com.fakestore.FakeStoreAPI.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class Rating {
    @Min((long) 1.0)
    @Max((long) 5.0)
    private Double rate;
    private Integer count;
}
