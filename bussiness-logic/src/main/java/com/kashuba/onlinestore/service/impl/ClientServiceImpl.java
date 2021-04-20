package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.ClientRepository;
import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.service.ClientService;
import com.kashuba.onlinestore.service.converter.ClientConverter;
import com.kashuba.onlinestore.service.dto.ClientDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    // TODO сделать бинами
    ClientConverter clientConverter = new ClientConverter();
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


    //Запились passwordEncoder
    @Override
    public Client create(ClientDto clientDto) {
        Client client = clientConverter.toModel(clientDto);
        client.setRole(Client.Role.findRole("client"));
        client.setStatus(Client.Status.findStatus("active"));
        client.setPassword(passwordEncoder.encode(clientDto.getPassword()));
        return clientRepository.saveAndFlush(client);
    }

    //        cartRepository.saveAndFlush(cart);
//        clientRepository.saveAndFlush(client);
    @Override
    public void deleteById(Long id) {
//        clientRepository.delete(client);
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }
}
