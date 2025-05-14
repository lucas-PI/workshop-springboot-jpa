package com.educando.course.dto.order;

import com.educando.course.entites.enums.OrderStatus;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Data

public class OrderPostRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Instant moment;
    private OrderStatus orderStatus;
    private Long idClient;
    @Builder
    public OrderPostRequest(Instant moment, String orderStatus, Long idClient) {
        this.moment = moment;
        this.orderStatus = OrderStatus.valueOf(orderStatus.toUpperCase().replace(" ","_"));
        this.idClient = idClient;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }
}
