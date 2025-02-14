package ec.akira.akira_negocios.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.akira.akira_negocios.model.entity.Branches;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/branchesRest")
public class BranchesController {

    @PostMapping("/createBranch")
    public ResponseEntity<Branches> createBranch(@RequestBody Branches branch) {
        // TODO: process POST request

        return ResponseEntity.ok().body(branch);
    }

}
