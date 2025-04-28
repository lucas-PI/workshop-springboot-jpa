package com.educando.course.mapper;

import com.educando.course.dto.product.ProductPostRequest;
import com.educando.course.dto.product.ProductPutRequest;
import com.educando.course.entites.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    public abstract Product toProduct(ProductPostRequest productPostRequest);
    public abstract Product toProduct(ProductPutRequest productPutRequest);

}
