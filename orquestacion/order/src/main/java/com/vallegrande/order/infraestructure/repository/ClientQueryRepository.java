package com.vallegrande.order.infraestructure.repository;

import com.vallegrande.order.infraestructure.repository.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientQueryRepository extends JpaRepository<ClientEntity, Long> {
}
