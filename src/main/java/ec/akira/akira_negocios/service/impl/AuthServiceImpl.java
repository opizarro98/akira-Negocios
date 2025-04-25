package ec.akira.akira_negocios.service.impl;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ec.akira.akira_negocios.config.JwtService;
import ec.akira.akira_negocios.model.dto.AuthResponse;
import ec.akira.akira_negocios.model.dto.LoginResponse;
import ec.akira.akira_negocios.model.dto.RegisterResponse;
import ec.akira.akira_negocios.model.entity.Person;
import ec.akira.akira_negocios.model.entity.User;
import ec.akira.akira_negocios.repository.PersonRepo;
import ec.akira.akira_negocios.repository.UserRepo;
import ec.akira.akira_negocios.service.AuthService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

        private final UserRepo userRepository;
        private final PersonRepo personRepository;
        private final JwtService jwtService;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;

        @Override
        public AuthResponse login(LoginResponse loginResponse) {
                try {
                        authenticationManager.authenticate(
                                        new UsernamePasswordAuthenticationToken(
                                                        loginResponse.getUsername(), loginResponse.getPassword()));

                        User user = userRepository.findByUsername(loginResponse.getUsername())
                                        .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

                        String token = jwtService.getToken(user);

                        return AuthResponse.builder()
                                        .token(token)
                                        .build();

                } catch (BadCredentialsException e) {
                        throw new BadCredentialsException(
                                        "Credenciales incorrectas. Verifica tu usuario y contraseña.");
                } catch (UsernameNotFoundException e) {
                        throw new UsernameNotFoundException("El usuario no existe.");
                }
        }

        @Transactional
        @Override
        public AuthResponse register(RegisterResponse registerResponse) {
                try {
                        if (userRepository.existsByUsername(registerResponse.getUsername())) {
                                throw new IllegalArgumentException("El nombre de usuario no esta disponible");
                        }

                        Person person = Person.builder()
                                        .identification(registerResponse.getIdentification())
                                        .firstName(registerResponse.getFirstname())
                                        .lastName(registerResponse.getLastname())
                                        .mobilePhone(registerResponse.getMobilePhone())
                                        .email(registerResponse.getEmail())
                                        .birthDate(registerResponse.getBirthdate())
                                        .type(registerResponse.getTypePerson())
                                        .address(registerResponse.getAddress())
                                        .build();

                        personRepository.save(person);

                        User user = User.builder()
                                        .username(registerResponse.getUsername())
                                        .password(passwordEncoder.encode(registerResponse.getPassword()))
                                        .role(registerResponse.getRolUser())
                                        .person(person)
                                        .build();

                        userRepository.save(user);

                        String token = jwtService.getToken(user);

                        return AuthResponse.builder()
                                        .token(token)
                                        .build();

                } catch (DataIntegrityViolationException e) {
                        throw new RuntimeException("Error de integridad de datos al registrar usuario o persona: "
                                        + e.getMessage());
                } catch (Exception e) {
                        throw new RuntimeException("Error al registrar usuario: " + e.getMessage());
                }

        }

}
