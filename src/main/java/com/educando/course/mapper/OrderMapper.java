package com.educando.course.mapper;

import com.educando.course.dto.order.OrderPostRequest;
import com.educando.course.entites.Order;
import com.educando.course.entites.User;
import com.educando.course.services.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {

    @Autowired
    private UserService userService;

    @Mapping(source = "idClient", target = "client")
    public abstract Order toOrder(OrderPostRequest orderPostRequest);

    protected User map(Long idClient){
        return userService.findById(idClient);
    }
}
