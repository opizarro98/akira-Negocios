package ec.akira.akira_negocios.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ec.akira.akira_negocios.model.dto.user.UserResponse;
import ec.akira.akira_negocios.model.entity.User;
import ec.akira.akira_negocios.repository.UserRepo;
import ec.akira.akira_negocios.service.UserService;
import ec.akira.akira_negocios.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createNewUser(UserResponse user) {
        User newuser = User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRoleUser())
                .build();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(newuser);
        return UserResponse.builder()
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
