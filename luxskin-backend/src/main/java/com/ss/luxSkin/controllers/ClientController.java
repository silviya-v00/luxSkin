package com.ss.luxSkin.controllers;

import com.ss.luxSkin.entities.Client;
import com.ss.luxSkin.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("client")

public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/allClients")
    public List<Client> getAllClients()
    {
        return clientRepository.findAll();
    }

    @PostMapping("/addClient/save")
    public ResponseEntity<?> saveClient(@RequestBody Client form){
        boolean isNew = form.getName() == null;
        Client client = clientRepository.save(form);
        Map<String, Object> response = new HashMap<>();
        response.put("generatedId", client.getName());
        if (isNew){
            response.put("message", "Успешно записан!");}
        else {
            response.put("message", "Успешно редактиран!");}


        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/addClient")
    public ResponseEntity<?> saveOrUpdate (@RequestParam(required = false) Long id,
                                           @RequestParam(required = false) String name,
                                           @RequestParam(required = false) String email,
                                           @RequestParam(required = false) String product_name,
                                           @RequestParam(required = false) Integer count_client,
                                           @RequestParam(required = false) String price){


        boolean isNew = id == null;

        Client client = new Client(id, name, email, product_name, count_client, price);
        client = clientRepository.save(client);
        Map<String, Object> response = new HashMap<>();
        response.put("generatedId", client.getName());
        if (isNew){
            response.put("message", "Успешно записан!");}
        else {
            response.put("message", "Успешно редактиран!");}


        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity getId(@RequestParam(required = false) String name) {
        if (name == null || name.isBlank()) {
            return ResponseEntity.ok().body("Не сте въвели име");
        }
        Optional<Client> result = clientRepository.findClientByName(name.toLowerCase());
        return result.isPresent()?ResponseEntity.ok(result.get()) : ResponseEntity.ok("Няма намерена поръчка!");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteClient(@RequestParam Long id) {

        if(!clientRepository.existsById(id))
        {
            return ResponseEntity.ok("Няма такъв продукт!");
        }

        clientRepository.deleteById(id);
        return ResponseEntity.ok("Изтрит успешно!");
    }
}

