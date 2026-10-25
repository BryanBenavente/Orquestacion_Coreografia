package com.vallegrande.order.infraestructure.repository.impl;

import com.vallegrande.order.domain.sales.InfoClient;
import com.vallegrande.order.domain.sales.services.ConsultationClientService;
import com.vallegrande.order.infraestructure.repository.ClientQueryRepository;
import com.vallegrande.order.infraestructure.repository.entity.ClientEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientRepositoryImpl implements ConsultationClientService {

    private final ClientQueryRepository clientQueryRepository;

    public ClientRepositoryImpl(ClientQueryRepository clientQueryRepository) {
        this.clientQueryRepository = clientQueryRepository;
    }

    @Override
    public InfoClient searchClientById(Long clientId) {
        Optional<ClientEntity> clientEntity = clientQueryRepository.findById(clientId);
        InfoClient client = null;

        if(clientEntity.isPresent())
            client = new InfoClient(
                    clientEntity.get().getId(),
                    clientEntity.get().getName()
            );

        return client;
    }

}
