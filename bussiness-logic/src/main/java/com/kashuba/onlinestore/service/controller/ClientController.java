package com.kashuba.onlinestore.service.controller;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.service.ClientService;
import com.kashuba.onlinestore.service.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Client createClient(@RequestBody ClientDto clientDto) {
        return clientService.create(clientDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Long id) {  //String clientId
//        Client client = new Client();
//        client.setId(Long.parseLong(clientId));
        clientService.deleteById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Client> findAllClients() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Optional<Client> findById(@PathVariable("id") Long id) {
        return clientService.findById(id);
    }


}
