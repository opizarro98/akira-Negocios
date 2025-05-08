package ec.akira.akira_negocios.service;

import ec.akira.akira_negocios.model.dto.registreUser.EmployeeRegisterResponse;

public interface EmployeeService {

    EmployeeRegisterResponse createEmployee(EmployeeRegisterResponse employee);
}
