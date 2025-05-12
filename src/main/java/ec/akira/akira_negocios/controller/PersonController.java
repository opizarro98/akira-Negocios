package ec.akira.akira_negocios.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.akira.akira_negocios.model.entity.Person;
import ec.akira.akira_negocios.service.PersonService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/personRest")
@CrossOrigin(origins = { "*" })
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/CreateNewPerson")
    public ResponseEntity<Person> postMethodName(@RequestBody Person person) {

        return ResponseEntity.ok().body(person);
    }

    @GetMapping("/personExistByIdentification/{identification}")
    public boolean getMethodName(@PathVariable String identification) {
        return personService.PersonExistsByIdentification(identification);
    }
}
