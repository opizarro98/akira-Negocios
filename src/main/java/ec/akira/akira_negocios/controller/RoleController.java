package ec.akira.akira_negocios.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.akira.akira_negocios.model.entity.Role;
import ec.akira.akira_negocios.service.RoleService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/roleRest")
@CrossOrigin(origins = { "*" })
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/createNewRole")
    public ResponseEntity<Role> newRole(@RequestBody Role role) {
        return ResponseEntity.ok().body(roleService.createRole(role));
    }
}
