package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.ClientRepository;
import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.service.ClientService;
import com.kashuba.onlinestore.service.converter.ClientConverter;
import com.kashuba.onlinestore.service.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class ClientServiceImpl implements ClientService {

    ClientConverter clientConverter = new ClientConverter();
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(ClientDto clientDto) {
        Client client = clientConverter.toModel(clientDto);

        return clientRepository.saveAndFlush(client);
    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    @Override
    public List<Client> findClients() {
        return clientRepository.findAll();
    }
}
