package ec.akira.akira_negocios.service.impl;

import org.springframework.stereotype.Service;

import ec.akira.akira_negocios.model.entity.User;
import ec.akira.akira_negocios.repository.UserRepo;
import ec.akira.akira_negocios.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;

    @Override
    public User CreateNewUser(User user) {
        return userRepository.save(user);
    }

}
