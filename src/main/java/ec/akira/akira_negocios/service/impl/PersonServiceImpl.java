package ec.akira.akira_negocios.service.impl;

import org.springframework.stereotype.Service;

import ec.akira.akira_negocios.model.dto.person.PersonResponse;
import ec.akira.akira_negocios.repository.PersonRepo;
import ec.akira.akira_negocios.service.PersonService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepo personRepository;

    @Override
    public PersonResponse createNewPerson(PersonResponse newperson) {

        return null;

    }

    @Override
    public Boolean PersonExistsByIdentification(String identification) {
        if (personRepository.findByIdentification(identification) != null) {
            return true;
        } else {
            return false;
        }
    }
}
