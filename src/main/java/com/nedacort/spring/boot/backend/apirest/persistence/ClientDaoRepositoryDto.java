package com.nedacort.spring.boot.backend.apirest.persistence;

import com.nedacort.spring.boot.backend.apirest.domain.ClientDTO;
import com.nedacort.spring.boot.backend.apirest.domain.repository.ClientDtoRepository;
import com.nedacort.spring.boot.backend.apirest.persistence.crud.ClientDAO;
import com.nedacort.spring.boot.backend.apirest.persistence.entity.Client;
import com.nedacort.spring.boot.backend.apirest.persistence.mapper.ClientDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientDaoRepositoryDto implements ClientDtoRepository {

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private ClientDtoMapper clientDtoMapper;


    @Override
    public List<ClientDTO> getAll() {

        return clientDtoMapper.toClientDtos((List<Client>) clientDAO.findAll());
    }

    @Override
    public Optional<ClientDTO> getClientById(Integer id) {
        System.out.println(clientDAO.findById(id));
        return clientDAO.findById(id).map(client -> clientDtoMapper.toClientDto(client));
    }

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        return clientDtoMapper.toClientDto(clientDAO.save(clientDtoMapper.toClient(clientDTO)));
    }


    @Override
    public void delete(Integer id) {
        clientDAO.deleteById(id);
    }
}
