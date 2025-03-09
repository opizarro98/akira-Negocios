package ec.akira.akira_negocios.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.akira.akira_negocios.model.entity.Bank;

@RestController
@RequestMapping("/bankRest")
public class BankController {

    @PostMapping("/createBank")
    public ResponseEntity<Bank> createBranch(@RequestBody Bank bank) {
        // TODO: process POST request

        return ResponseEntity.ok().body(bank);
    }
}
