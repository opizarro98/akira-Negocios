package ec.akira.akira_negocios.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.akira.akira_negocios.model.entity.Company;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/companyRest")
public class CompanyController {

    @PostMapping("/CreateCompany")
    public ResponseEntity<Company> CreateCompany(@RequestBody Company company) {

        return ResponseEntity.ok().body(company);
    }
}
