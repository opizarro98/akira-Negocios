package ec.akira.akira_negocios.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.akira.akira_negocios.model.entity.Person;
import ec.akira.akira_negocios.repository.PersonRepo;
import ec.akira.akira_negocios.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepo personRepo;

    @Override
    public Person createNewPerson(Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createNewPerson'");
    }

}
