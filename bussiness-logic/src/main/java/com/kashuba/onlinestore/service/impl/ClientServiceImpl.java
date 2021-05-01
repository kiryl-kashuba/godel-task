package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.converter.ClientConverter;
import com.kashuba.onlinestore.dao.CartRepository;
import com.kashuba.onlinestore.dao.ClientRepository;
import com.kashuba.onlinestore.dto.ClientDto;
import com.kashuba.onlinestore.entity.Cart;
import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientConverter clientConverter;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CartRepository cartRepository;

    @Override
    public ClientDto create(ClientDto clientDto) {
        Cart cart = new Cart();
        cartRepository.saveAndFlush(cart);
        Client client = clientConverter.toModel(clientDto);
        client.setRole(Client.Role.findRole("CLIENT"));
        client.setStatus(Client.Status.findStatus("ACTIVE"));
        client.setPassword(passwordEncoder.encode(clientDto.getPassword()));
        client.setCart(cart);
        return clientConverter.toDto(clientRepository.saveAndFlush(client));
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientConverter.toListDto(clientRepository.findAll());
    }

    @Override
    public Optional<ClientDto> findById(Long id) {
        return clientConverter.toOptionalDto(clientRepository.findById(id));
    }
}
