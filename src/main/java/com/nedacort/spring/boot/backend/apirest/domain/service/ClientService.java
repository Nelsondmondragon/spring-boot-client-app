package com.nedacort.spring.boot.backend.apirest.domain.service;

import com.nedacort.spring.boot.backend.apirest.domain.ClientDTO;
import com.nedacort.spring.boot.backend.apirest.domain.repository.ClientDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientDtoRepository clientDtoRepository;

    public List<ClientDTO> getAll() {
        return clientDtoRepository.getAll();
    }

    public Optional<ClientDTO> getClientById(Integer id) {
        return clientDtoRepository.getClientById(id);
    }

    public ClientDTO save(ClientDTO clientDTO) {
        return clientDtoRepository.save(clientDTO);
    }

    public boolean delete(Integer id) {
        return getClientById(id).map(clientDTO -> {
            clientDtoRepository.delete(id);
            return true;
        }).orElse(false);
    }
}
