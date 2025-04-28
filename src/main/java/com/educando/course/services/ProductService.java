package com.educando.course.services;

import com.educando.course.dto.product.ProductPostRequest;
import com.educando.course.dto.product.ProductPutRequest;
import com.educando.course.entites.Product;
import com.educando.course.mapper.ProductMapper;
import com.educando.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public List<Product> findAll(){
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    public Product findById(Long id){
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }
    @Transactional
    public Product insert(ProductPostRequest productPostRequest){
        return productRepository.save(productMapper.toProduct(productPostRequest));
    }
    public void delete(Long id){
        productRepository.deleteById(id);
    }

    public Product update(Long id, ProductPutRequest productPutRequest){
        Product entity = productRepository.getReferenceById(id);
        updateDate(entity, productMapper.toProduct(productPutRequest));
        return productRepository.save(entity);
    }

    private void updateDate(Product entity, Product obj) {
        entity.setName(obj.getName());
        entity.setDescription(obj.getDescription());
        entity.setPrice(obj.getPrice());
        entity.setImgUrl(obj.getImgUrl());
    }

}
