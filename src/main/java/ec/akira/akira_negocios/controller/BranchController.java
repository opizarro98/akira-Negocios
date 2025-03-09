package ec.akira.akira_negocios.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.akira.akira_negocios.model.entity.Branch;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/branchesRest")
public class BranchController {

    @PostMapping("/createBranch")
    public ResponseEntity<Branch> createBranch(@RequestBody Branch branch) {
        // TODO: process POST request

        return ResponseEntity.ok().body(branch);
    }

}
