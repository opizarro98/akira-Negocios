package ec.akira.akira_negocios.service;

import ec.akira.akira_negocios.model.dto.user.ClientResgisterResponse;

public interface UserService {

    ClientResgisterResponse createNewUser(ClientResgisterResponse user);
}
