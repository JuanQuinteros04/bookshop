package com.quinteros.service;

import com.quinteros.exceptions.NotFoundException;
import com.quinteros.model.dto.ClientDTO;
import com.quinteros.model.dto.ClientResponse;
import com.quinteros.model.mapper.ClientMapper;
import com.quinteros.persistence.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    ClientMapper clientMapper = ClientMapper.INSTANCE;
    @Override
    public List<ClientResponse> findAll() {
        return clientRepository.findAll().stream().map(client -> clientMapper.clientToClientResponse(client)).collect(Collectors.toList());
    }

    @Override
    public ClientResponse findById(Long id) {
        return clientMapper.clientToClientResponse(clientRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public ClientResponse createClient(ClientDTO clientDTO) {
        return null;
    }

    @Override
    public void updateClient(Long id, ClientDTO clientDTO) {

    }

    @Override
    public void deleteClient(Long id) {

    }
}
