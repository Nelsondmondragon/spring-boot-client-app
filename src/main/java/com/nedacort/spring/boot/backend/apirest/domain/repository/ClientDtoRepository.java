package com.nedacort.spring.boot.backend.apirest.domain.repository;

import com.nedacort.spring.boot.backend.apirest.domain.ClientDTO;

import java.util.List;
import java.util.Optional;

public interface ClientDtoRepository {

    List<ClientDTO> getAll();

    Optional<ClientDTO> getClientById(Integer id);

    ClientDTO save(ClientDTO clientDTO);

    void delete(Integer id);
}
