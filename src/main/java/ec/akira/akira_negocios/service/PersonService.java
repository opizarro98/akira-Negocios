package ec.akira.akira_negocios.service;

import ec.akira.akira_negocios.model.dto.person.PersonResponse;

public interface PersonService {

    PersonResponse createNewPerson(PersonResponse person);
}
