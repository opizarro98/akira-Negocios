package ec.akira.akira_negocios.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.akira.akira_negocios.model.entity.Client;

@RestController
@RequestMapping("/clientRest")
public class ClientController {

    @PostMapping("/createClient")
    public ResponseEntity<Client> createBranch(@RequestBody Client client) {
        // TODO: process POST request

        return ResponseEntity.ok().body(client);
    }
}
