package com.educando.course.dto.product;


import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ProductPostRequest implements Serializable {

    @NotEmpty(message = "name field can't empty")
    private String name;
    @NotEmpty(message = "description field can't empty")
    private String description;
    @NotEmpty(message = "price field can't empty")
    private Double price;
    @NotEmpty(message = "imgUrl field can't empty")
    private String imgUrl;
}
