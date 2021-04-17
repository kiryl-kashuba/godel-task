package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.service.dto.ClientDto;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client create(ClientDto clientDto);

    void deleteById(Long id);

    List<Client> findAll();

    Optional<Client> findById(Long id);

    Client findByEmail(String email);


}
