package ec.akira.akira_negocios.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import ec.akira.akira_negocios.config.JwtService;
import ec.akira.akira_negocios.model.dto.AuthResponse;
import ec.akira.akira_negocios.model.dto.LoginRequest;
import ec.akira.akira_negocios.model.dto.RegisterRequest;
import ec.akira.akira_negocios.model.entity.User;
import ec.akira.akira_negocios.repository.UserRepository;
import ec.akira.akira_negocios.service.AuthService;

public class AuthServiceImpl implements AuthService {

        private final UserRepository userRepository;
        private final JwtService jwtService;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;

        @Override
        public AuthResponse login(LoginRequest request) {
                authenticationManager
                                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
                                                request.getPassword()));
                /*
                 * UserDetails user =
                 * userRepository.findByUsername(request.getUsername()).orElseThrow();
                 * String personName = userRepository.findByUsername(request
                 * .getUsername()).get().getFirstname() + " " + userRepository.findByUsername(
                 * request
                 * .getUsername())
                 * .get().getLastname();
                 * String token = jwtService.getToken(user);
                 */
                return AuthResponse.builder()
                                .token(token)
                                .userName(personName)
                                .build();

        }

        @Override
        public AuthResponse register(RegisterRequest request) {
                User user = User.builder()
                                .username(request.getUsername())
                                .password(passwordEncoder.encode(request.getPassword()))
                                // .firsname(request.getFirstname())
                                // .lastname(request.lastname)
                                // .country(request.getCountry())
                                // .role(Role.USER)
                                .build();

                userRepository.save(user);

                return AuthResponse.builder()
                                .token(jwtService.getToken(user))
                                .build();

        }

}
