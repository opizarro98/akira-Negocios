package ec.akira.akira_negocios.service;

import ec.akira.akira_negocios.model.dto.user.ClientResgisterResponse;

public interface ClientService {

    ClientResgisterResponse createNewClientUser(ClientResgisterResponse clientResgisterResponse);
}
