package ec.akira.akira_negocios.service;

import ec.akira.akira_negocios.model.dto.AuthResponse;
import ec.akira.akira_negocios.model.dto.LoginResponse;
import ec.akira.akira_negocios.model.dto.registreUser.EmployeeRegisterResponse;

public interface AuthService {
    AuthResponse login(LoginResponse request);

    AuthResponse register(EmployeeRegisterResponse request);

}
