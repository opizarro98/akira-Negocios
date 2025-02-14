package ec.akira.akira_negocios.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.akira.akira_negocios.model.entity.People;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/personaRest")
public class PersonController {

    @PostMapping("/CreateNewPerson")
    public ResponseEntity<People> postMethodName(@RequestBody People person) {

        return ResponseEntity.ok().body(person);
    }
}
