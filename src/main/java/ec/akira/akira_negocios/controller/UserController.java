package ec.akira.akira_negocios.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.akira.akira_negocios.model.dto.user.ClientResgisterResponse;
import ec.akira.akira_negocios.service.UserService;
import ec.akira.akira_negocios.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    @PostMapping("/createNewUser")
    public ResponseEntity<ClientResgisterResponse> CreateNewUser(@RequestBody ClientResgisterResponse user) {
        return ResponseEntity.ok().body(userService.createNewUser(user));
    }

}
