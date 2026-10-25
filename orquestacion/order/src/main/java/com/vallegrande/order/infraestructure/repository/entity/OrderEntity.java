package com.vallegrande.order.infraestructure.repository.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntity client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderLineEntity> orderLines;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public List<OrderLineEntity> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLineEntity> orderLines) {
        this.orderLines = orderLines;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
