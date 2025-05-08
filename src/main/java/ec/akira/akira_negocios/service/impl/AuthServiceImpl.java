package ec.akira.akira_negocios.service.impl;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ec.akira.akira_negocios.config.JwtService;
import ec.akira.akira_negocios.model.dto.AuthResponse;
import ec.akira.akira_negocios.model.dto.LoginResponse;
import ec.akira.akira_negocios.model.dto.registreUser.EmployeeRegisterResponse;
import ec.akira.akira_negocios.model.entity.Employee;
import ec.akira.akira_negocios.model.entity.Person;
import ec.akira.akira_negocios.model.entity.User;
import ec.akira.akira_negocios.repository.EmployeeRepo;
import ec.akira.akira_negocios.repository.PersonRepo;
import ec.akira.akira_negocios.repository.UserRepo;
import ec.akira.akira_negocios.service.AuthService;
import ec.akira.akira_negocios.service.mapper.registerclient.PersonUserRegisterMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

        private final UserRepo userRepository;
        private final PersonRepo personRepository;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;
        private final PersonUserRegisterMapper personUserRegisterMapper;
        private final EmployeeRepo employeeRepository;

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
        public AuthResponse register(EmployeeRegisterResponse registerResponse) {
                try {
                        if (userRepository.existsByUsername(registerResponse.getUsername())) {
                                throw new IllegalArgumentException("El nombre de usuario no esta disponible");
                        }
                        Person person = personRepository
                                        .save(personUserRegisterMapper.toPersonEmployee(registerResponse));
                        User user = userRepository
                                        .save(personUserRegisterMapper.toUserEmployee(registerResponse, person));
                        Employee employeeEntity = Employee.builder()
                                        .position(registerResponse.getPosition())
                                        .salary(registerResponse.getSalary())
                                        .hireDate(registerResponse.getHireDate())
                                        .status(registerResponse.getStatus())
                                        .person(person)
                                        .build();
                        employeeRepository.save(employeeEntity);
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
