package com.nedacort.spring.boot.backend.apirest.persistence.mapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nedacort.spring.boot.backend.apirest.domain.ClientDTO;
import com.nedacort.spring.boot.backend.apirest.persistence.entity.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientDtoMapper {


    ClientDTO toClientDto(Client client);

    List<ClientDTO> toClientDtos(List<Client> clients);

    @InheritInverseConfiguration
    Client toClient(ClientDTO clientDTO);
}
