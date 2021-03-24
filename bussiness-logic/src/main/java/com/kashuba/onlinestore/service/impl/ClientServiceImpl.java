package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.ClientDao;
import com.kashuba.onlinestore.dao.ClientRepository;
import com.kashuba.onlinestore.dao.impl.ClientDaoImpl;
import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    private ClientDao clientDao = ClientDaoImpl.getInstance();

    private static ClientServiceImpl instance;

    private ClientServiceImpl() {
    }

    public static ClientServiceImpl getInstance() {
        if (instance == null) {
            instance = new ClientServiceImpl();
        }
        return instance;
    }

    @Override
    public Client createClient(Client client) {
        Client savedClient = clientRepository.saveAndFlush(client);
        return savedClient;
    }

    @Override
    public void deleteClient(long id) {
        clientRepository.delete(id);
    }

    @Override
    public List<Client> findClients() {
        return clientRepository.findAll();
    }


}
