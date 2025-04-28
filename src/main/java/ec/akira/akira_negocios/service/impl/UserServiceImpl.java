package ec.akira.akira_negocios.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ec.akira.akira_negocios.model.dto.person.PersonResponse;
import ec.akira.akira_negocios.model.dto.user.ClientResgisterResponse;
import ec.akira.akira_negocios.model.entity.User;
import ec.akira.akira_negocios.repository.UserRepo;
import ec.akira.akira_negocios.service.PersonService;
import ec.akira.akira_negocios.service.UserService;
import ec.akira.akira_negocios.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final PersonService personService;

    @Override
    public ClientResgisterResponse createNewUser(ClientResgisterResponse user) {
        PersonResponse person = PersonResponse.builder()
                .identification(user.getIdentification())
                .firstname(user.getFirstname())
                .middleName(user.getMiddlename())
                .lastname(user.getLastname())
                .secondLastName(user.getSecondlastname())
                .landlinePhone(user.getLandlinephone())
                .mobilePhone(user.getMobilePhone())
                .email(user.getEmail())
                .birthDate(user.getBirthdate())
                .address(user.getAddress())
                .typePerson(user.getTypePerson())
                .totalDebt(user.getTotalDebt()).build();
        personService.createNewPerson(person);

        User newuser = User.builder()
                .username(user.getUsername())
                .password(passwordEncoder.encode(user
                        .getPassword()))
                .role(user.getRoleUser())
                .build();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(newuser);
        return ClientResgisterResponse.builder()
                .username(newuser.getUsername())
                .password(newuser.getPassword())
                .roleUser(newuser.getRole())
                .identification(user.getIdentification())
                .firstname(user.getFirstname())
                .middlename(user.getMiddlename())
                .lastname(user.getLastname())
                .secondlastname(user.getSecondlastname())
                .landlinephone(user.getLandlinephone())
                .mobilePhone(user.getMobilePhone())
                .email(user.getEmail())
                .birthdate(user.getBirthdate())
                .address(user.getAddress())
                .typePerson(user.getTypePerson())
                .totalDebt(user.getTotalDebt()).build();
    }

}
