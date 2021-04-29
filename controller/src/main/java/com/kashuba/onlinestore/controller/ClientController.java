package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.service.ClientService;
import com.kashuba.onlinestore.service.dto.ClientDto;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
@Api(tags = "Controller of clients")
@Validated
@Slf4j
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Operation(summary = "Create client")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto createClient(@Valid @RequestBody ClientDto clientDto) {
        log.info("Creating client {}", clientDto.getEmail());
        return clientService.create(clientDto);
    }

    @Operation(summary = "Delete client by its id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @PathVariable("id") Long id) {
        log.info("Deleting client {}", id);
        clientService.deleteById(id);
    }

    @Operation(summary = "Find all clients")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDto> findAllClients() {
        log.info("Finding all clients");
        return clientService.findAll();
    }

    @Operation(summary = "Find client by its id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ClientDto> findById(@Valid @PathVariable("id") Long id) {
        log.info("Finding client {}", id);
        return clientService.findById(id);
    }


}