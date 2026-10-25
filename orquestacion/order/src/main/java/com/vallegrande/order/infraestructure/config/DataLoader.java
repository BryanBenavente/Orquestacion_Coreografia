package com.vallegrande.order.infraestructure.config;

import com.vallegrande.order.infraestructure.repository.ClientQueryRepository;
import com.vallegrande.order.infraestructure.repository.entity.ClientEntity;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ClientQueryRepository clientQueryRepository;

    public DataLoader(ClientQueryRepository clientQueryRepository) {
        this.clientQueryRepository = clientQueryRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<ClientEntity> clients = Arrays.asList(
                new ClientEntity("Jorge Luis"),
                new ClientEntity("Maria Laura"),
                new ClientEntity("Valeria"),
                new ClientEntity("Armando Pablo")
        );

        clientQueryRepository.saveAll(clients);
    }

}
