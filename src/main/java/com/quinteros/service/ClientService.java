package com.quinteros.service;

import com.quinteros.model.dto.ClientDTO;
import com.quinteros.model.dto.ClientResponse;

import java.util.List;

public interface ClientService {

    List<ClientResponse> findAll();

    ClientResponse findClientById(Long id);

    ClientResponse createClient(ClientDTO clientDTO);
    void updateClient(Long id, ClientDTO clientDTO);

    void deleteClient(Long id);


}
