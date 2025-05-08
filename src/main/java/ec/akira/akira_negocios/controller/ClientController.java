package ec.akira.akira_negocios.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.akira.akira_negocios.model.dto.registreUser.ClientResgisterResponse;
import ec.akira.akira_negocios.service.ClientService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientRest")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/createClientUser")
    public ResponseEntity<ClientResgisterResponse> createNewClient(
            @RequestBody ClientResgisterResponse clientResgisterResponse) {
        return ResponseEntity.ok().body(clientService.createNewClient(clientResgisterResponse));
    }
}
