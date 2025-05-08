package ec.akira.akira_negocios.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.akira.akira_negocios.model.dto.registreUser.EmployeeRegisterResponse;
import ec.akira.akira_negocios.service.EmployeeService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/employeeRest")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/createEmployeeUser")
    public ResponseEntity<EmployeeRegisterResponse> createNewEmpolyee(
            @RequestBody EmployeeRegisterResponse employeeRegisterResponse) {
        return ResponseEntity.ok().body(employeeService.createEmployee(employeeRegisterResponse));
    }

}
