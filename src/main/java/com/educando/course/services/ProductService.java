package com.educando.course.services;

import com.educando.course.entites.Product;
import com.educando.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    public Product findById(Long id){
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }

    public Product insert(Product obj){
        return productRepository.save(obj);
    }
    public void delete(Long id){
        productRepository.deleteById(id);
    }
    public Product update(Long id, Product obj){
        Product entity = productRepository.getReferenceById(id);
        updateDate(entity, obj);
        return productRepository.save(entity);
    }

    private void updateDate(Product entity, Product obj) {
        entity.setName(obj.getName());
        entity.setDescription(obj.getDescription());
        entity.setPrice(obj.getPrice());
        entity.setImgUrl(obj.getImgUrl());
    }
}
