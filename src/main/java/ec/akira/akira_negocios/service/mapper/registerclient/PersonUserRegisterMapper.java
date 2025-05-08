package ec.akira.akira_negocios.service.mapper.registerclient;

import java.time.LocalDateTime;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import ec.akira.akira_negocios.model.dto.registreUser.ClientResgisterResponse;
import ec.akira.akira_negocios.model.dto.registreUser.EmployeeRegisterResponse;
import ec.akira.akira_negocios.model.entity.Person;
import ec.akira.akira_negocios.model.entity.User;

@Mapper(componentModel = "spring")
public abstract class PersonUserRegisterMapper {

    @Autowired
    protected PasswordEncoder passwordEncoder;

    public User toUserClient(ClientResgisterResponse dto, Person person) {
        User user = User.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(dto.getRoleUser())
                .person(person)
                .build();
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("SYSTEM");
        return user;
    }

    public Person toPersonClient(ClientResgisterResponse dto) {
        Person person = Person.builder()
                .identification(dto.getIdentification())
                .firstName(dto.getFirstName())
                .middleName(dto.getMiddleName())
                .lastName(dto.getLastName())
                .secondLastName(dto.getSecondLastName())
                .landlinePhone(dto.getLandlinePhone())
                .mobilePhone(dto.getMobilePhone())
                .email(dto.getEmail())
                .birthDate(dto.getBirthDate())
                .address(dto.getAddress())
                .type(dto.getType()).build();

        person.setCreatedAt(LocalDateTime.now());
        person.setCreatedBy("SYSTEM");
        return person;
    }

    public User toUserEmployee(EmployeeRegisterResponse dto, Person person) {
        User user = User.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(dto.getRoleUser())
                .person(person)
                .build();
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("SYSTEM");
        return user;
    }

    public Person toPersonEmployee(EmployeeRegisterResponse dto) {
        Person person = Person.builder()
                .identification(dto.getIdentification())
                .firstName(dto.getFirstName())
                .middleName(dto.getMiddleName())
                .lastName(dto.getLastName())
                .secondLastName(dto.getSecondLastName())
                .landlinePhone(dto.getLandlinePhone())
                .mobilePhone(dto.getMobilePhone())
                .email(dto.getEmail())
                .birthDate(dto.getBirthDate())
                .address(dto.getAddress())
                .type(dto.getType()).build();
        person.setCreatedAt(LocalDateTime.now());
        person.setCreatedBy("SYSTEM");
        return person;
    }
}
