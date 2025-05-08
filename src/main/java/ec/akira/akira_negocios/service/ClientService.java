package ec.akira.akira_negocios.service;

import ec.akira.akira_negocios.model.dto.registreUser.ClientResgisterResponse;

public interface ClientService {

    ClientResgisterResponse createNewClient(ClientResgisterResponse clientResgisterResponse);
}
