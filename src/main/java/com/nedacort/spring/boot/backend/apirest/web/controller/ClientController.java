package com.nedacort.spring.boot.backend.apirest.web.controller;

import com.nedacort.spring.boot.backend.apirest.domain.ClientDTO;
import com.nedacort.spring.boot.backend.apirest.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @GetMapping("/all")
    public ResponseEntity<List<ClientDTO>> getAll() {
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("id") Integer id) {
        return clientService.getClientById(id)
                .map(clientDTO -> new ResponseEntity<>(clientDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<ClientDTO> save(@RequestBody ClientDTO clientDTO) {
        return new ResponseEntity<>(clientService.save(clientDTO), HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ClientDTO> update(@RequestBody ClientDTO clientDTO, @PathVariable Integer id) {
        ClientDTO clientDTOActual = clientService.getClientById(id).get();
        clientDTOActual.setFirstName(clientDTO.getFirstName());
        clientDTOActual.setSecondName(clientDTO.getSecondName());
        clientDTOActual.setSurName(clientDTO.getSurName());
        clientDTOActual.setSecondSurName(clientDTO.getSecondSurName());
        clientDTOActual.setEmail(clientDTO.getEmail());
        return new ResponseEntity<>(clientService.save(clientDTOActual), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        return clientService.delete(id) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
