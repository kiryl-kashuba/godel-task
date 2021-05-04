package com.kashuba.onlinestore.controller;

import com.kashuba.onlinestore.dto.ClientDto;
import com.kashuba.onlinestore.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Validated
@Slf4j
@Api(tags = "Controller of clients", description = "Operations with clients")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 409, message = "The request could not be completed due to a conflict with the current state of the target resource."),
        @ApiResponse(code = 500, message = "Server ERROR. Something go wrong")
})
public class ClientController {
    @Autowired
    private ClientService clientService;

    @ApiOperation(value = "Registration/create client")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto createClient(@Valid @RequestBody ClientDto clientDto) {
        log.info("Creating client {}", clientDto.getEmail());
        return clientService.create(clientDto);
    }

    @ApiOperation(value = "Delete client")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @PathVariable("id") Long id) {
        log.info("Deleting client {}", id);
        clientService.deleteById(id);
    }

    @ApiOperation(value = "Find all clients")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDto> findAllClients() {
        log.info("Finding all clients");
        return clientService.findAll();
    }

    @ApiOperation(value = "Find client by ID")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ClientDto> findById(@Valid @PathVariable("id") Long id) {
        log.info("Finding client {}", id);
        return clientService.findById(id);
    }


}
