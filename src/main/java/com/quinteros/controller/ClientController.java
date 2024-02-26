package com.quinteros.controller;

import com.quinteros.model.dto.ClientDTO;
import com.quinteros.model.dto.ClientResponse;
import com.quinteros.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientResponse>> findAll(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientResponse> findClientById(@PathVariable("id")Long id){
        return ResponseEntity.ok(clientService.findClientById(id));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientResponse> createClient(ClientDTO clientDTO){
        return ResponseEntity.ok(clientService.createClient(clientDTO));
    }
}
