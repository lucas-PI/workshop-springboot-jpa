package com.educando.course.services;

import com.educando.course.entites.Order;
import com.educando.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }

    public Order insert(Order obj){
        return orderRepository.save(obj);
    }
    public void delete(Long id){ orderRepository.deleteById(id); }
    public Order update(Long id, Order obj){
        Order entity = orderRepository.getReferenceById(id);
        updateDate(entity, obj);
        return orderRepository.save(entity);
    }

    private void updateDate(Order entity, Order obj) {
        entity.setOrderStatus(obj.getOrderStatus());
    }
}
