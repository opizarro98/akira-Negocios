package ec.akira.akira_negocios.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import ec.akira.akira_negocios.model.dto.person.PersonResponse;
import ec.akira.akira_negocios.model.dto.user.ClientResgisterResponse;
import ec.akira.akira_negocios.model.entity.Client;
import ec.akira.akira_negocios.model.entity.Person;
import ec.akira.akira_negocios.service.ClientService;
import ec.akira.akira_negocios.service.PersonService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final PersonService personService;

    @Override
    public ClientResgisterResponse createNewClientUser(ClientResgisterResponse clientResgisterResponse) {
        // Create person
        PersonResponse personResponse = PersonResponse.builder()
                .firstname(clientResgisterResponse.getFirstname())
                .middleName(clientResgisterResponse.getMiddlename())
                .lastname(clientResgisterResponse.getLastname())
                .secondLastName(clientResgisterResponse.getSecondlastname())
                .email(clientResgisterResponse.getEmail())
                .birthDate(clientResgisterResponse.getBirthdate())
                .landlinePhone(clientResgisterResponse.getLandlinephone())
                .mobilePhone(clientResgisterResponse.getMobilePhone())
                .address(clientResgisterResponse.getAddress())
                .typePerson(clientResgisterResponse.getTypePerson())
                .build();
        PersonResponse personResponseCreated = personService.createNewPerson(personResponse);

        Person person = Person.builder()
                .identification(personResponseCreated.getIdentification())
                .firstName(personResponseCreated.getFirstname())
                .middleName(personResponseCreated.getMiddleName())
                .lastName(personResponseCreated.getLastname())
                .secondLastName(personResponseCreated.getSecondLastName())
                .landlinePhone(personResponseCreated.getLandlinePhone())
                .mobilePhone(personResponseCreated.getMobilePhone())
                .email(personResponseCreated.getEmail())
                .birthDate(personResponseCreated.getBirthDate())
                .address(personResponseCreated.getAddress())
                .type(personResponseCreated.getTypePerson())
                .build();

        // Create USER

        // Create CLIENT
        Client client = Client.builder()
                .person(person)
                .build();

        return clientResgisterResponse;
    }

}
