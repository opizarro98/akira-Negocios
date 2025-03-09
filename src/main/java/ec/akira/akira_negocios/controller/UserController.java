package ec.akira.akira_negocios.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.akira.akira_negocios.model.entity.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/createNewUser")
    public ResponseEntity<User> CreateNewUser(@RequestBody User user) {

        return ResponseEntity.ok().body(user);
    }

}
