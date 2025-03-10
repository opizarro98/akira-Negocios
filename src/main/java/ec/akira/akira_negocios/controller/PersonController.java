package ec.akira.akira_negocios.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.akira.akira_negocios.model.entity.Person;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/personRest")
public class PersonController {

    @PostMapping("/CreateNewPerson")
    public ResponseEntity<Person> postMethodName(@RequestBody Person person) {

        return ResponseEntity.ok().body(person);
    }
}
