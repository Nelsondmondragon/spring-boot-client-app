package com.nedacort.spring.boot.backend.apirest.persistence.crud;

import com.nedacort.spring.boot.backend.apirest.persistence.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientDAO extends CrudRepository<Client, Integer> {
}
