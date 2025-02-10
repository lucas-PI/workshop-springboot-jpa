package com.educando.course.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
public class Payment implements Serializable {

    private Long idPayment;
    private Instant moment;
    @OneToOne
    @MapsId
    private Order order;

    @Serial
    private static final long serialVersionUID = 1l;

    public Payment() {
    }

    public Payment(Long idPayment, Instant moment,Order order) {
        this.idPayment = idPayment;
        this.moment = moment;
        this.order = order;
    }

    public Long getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Long idPayment) {
        this.idPayment = idPayment;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
