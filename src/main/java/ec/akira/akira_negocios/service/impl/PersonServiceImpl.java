package ec.akira.akira_negocios.service.impl;

import org.springframework.stereotype.Service;

import ec.akira.akira_negocios.model.dto.person.PersonResponse;
import ec.akira.akira_negocios.service.PersonService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    @Override
    public PersonResponse createNewPerson(PersonResponse newperson) {

        return null;

    }

}
