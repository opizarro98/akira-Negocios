package ec.akira.akira_negocios.service.impl;

import org.springframework.stereotype.Service;

import ec.akira.akira_negocios.model.dto.registreUser.ClientResgisterResponse;
import ec.akira.akira_negocios.model.entity.Client;
import ec.akira.akira_negocios.model.entity.Person;
import ec.akira.akira_negocios.model.entity.User;
import ec.akira.akira_negocios.repository.ClientRepo;
import ec.akira.akira_negocios.repository.PersonRepo;
import ec.akira.akira_negocios.repository.UserRepo;
import ec.akira.akira_negocios.service.ClientService;
import ec.akira.akira_negocios.service.mapper.registerclient.PersonUserRegisterMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

        private final PersonRepo personRepository;

        private final ClientRepo clientRepository;

        private final UserRepo userRepository;

        private final PersonUserRegisterMapper personUserRegisterMapper;

        @Override
        @Transactional
        public ClientResgisterResponse createNewClient(ClientResgisterResponse clientResgisterResponse) {

                // Create person
                Person person = personRepository.save(personUserRegisterMapper.toPersonClient(clientResgisterResponse));

                // Create USER
                User user = personUserRegisterMapper.toUserClient(clientResgisterResponse, person);
                userRepository.save(user);

                // Create CLIENT
                Client client = Client.builder()
                                .person(person)
                                .build();

                clientRepository.save(client);

                return clientResgisterResponse;
        }

}
