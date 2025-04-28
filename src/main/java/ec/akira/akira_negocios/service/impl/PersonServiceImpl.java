package ec.akira.akira_negocios.service.impl;

import org.springframework.stereotype.Service;

import ec.akira.akira_negocios.model.dto.person.PersonResponse;
import ec.akira.akira_negocios.model.entity.Person;
import ec.akira.akira_negocios.repository.PersonRepo;
import ec.akira.akira_negocios.service.PersonService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepo personRepo;

    @Override
    public PersonResponse createNewPerson(PersonResponse newperson) {
        Person person = Person.builder()
                .identification(newperson.getIdentification())
                .firstName(newperson.getFirstname())
                .middleName(newperson.getMiddleName())
                .lastName(newperson.getLastname())
                .secondLastName(newperson.getSecondLastName())
                .landlinePhone(newperson.getLandlinePhone())
                .mobilePhone(newperson.getMobilePhone())
                .email(newperson.getEmail())
                .birthDate(newperson.getBirthDate())
                .address(newperson.getAddress())
                .type(newperson.getTypePerson())
                .totalDebt(newperson.getTotalDebt()).build();
        personRepo.save(person);
        return PersonResponse.builder()
                .personId(person.getPersonId())
                .identification(person.getIdentification())
                .firstname(person.getFirstName())
                .middleName(person.getMiddleName())
                .lastname(person.getLastName())
                .secondLastName(person.getSecondLastName())
                .landlinePhone(person.getLandlinePhone())
                .mobilePhone(person.getMobilePhone())
                .email(person.getEmail())
                .birthDate(person.getBirthDate())
                .address(person.getAddress())
                .typePerson(person.getType())
                .totalDebt(person.getTotalDebt()).build();

    }

}
