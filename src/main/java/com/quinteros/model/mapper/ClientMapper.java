package com.quinteros.model.mapper;

import com.quinteros.model.Client;
import com.quinteros.model.dto.ClientDTO;
import com.quinteros.model.dto.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "id", ignore = true)
    Client clientDTOToClient(ClientDTO client);

    ClientResponse clientToClientResponse(Client client);


}
