package com.educando.course.Controllers;

import com.educando.course.dto.order.OrderPostRequest;
import com.educando.course.entites.Order;
import com.educando.course.repositories.OrderRepository;
import com.educando.course.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAlL(){
        List<Order> listOrder = orderService.findAll();
        return ResponseEntity.ok().body(listOrder);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order = orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }
    @PostMapping
    public ResponseEntity<Order> insert(@RequestBody @Valid OrderPostRequest orderPostRequest){
        Order obj = orderService.insert(orderPostRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getIdOrder())
                .toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order obj){
        obj = orderService.update(id, obj);
        return ResponseEntity.ok(obj);
    }
}
