package com.kashuba.onlinestore.service.controller;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.service.ClientService;
import com.kashuba.onlinestore.service.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ProductAttributeValueController {
    private final ClientService clientService;

    @Autowired
    public ProductAttributeValueController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Client createClient(@RequestBody ClientDto clientDto) {
        return clientService.createClient(clientDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Client client) {
        clientService.deleteClient(client);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Client> findAllClients() {
        return clientService.findClients();
    }
}
