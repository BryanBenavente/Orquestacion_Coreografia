package com.vallegrande.order.domain.sales.services;


import com.vallegrande.order.domain.sales.InfoClient;

public interface ConsultationClientService {

    InfoClient searchClientById(Long clientId);

}
