package com.vallegrande.order.infraestructure.repository;

import com.vallegrande.order.infraestructure.repository.entity.OrderEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderCommandRepository extends JpaRepository<OrderEntity, Long> {

    @EntityGraph(attributePaths = {
            "client",
            "orderLines",
            "orderLines.book"
    })
    Optional<OrderEntity> findById(Long orderId);

}
