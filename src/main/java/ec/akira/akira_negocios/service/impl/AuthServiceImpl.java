package ec.akira.akira_negocios.service.impl;

import java.time.LocalDate;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ec.akira.akira_negocios.config.JwtService;
import ec.akira.akira_negocios.model.dto.AuthResponse;
import ec.akira.akira_negocios.model.dto.LoginResponse;
import ec.akira.akira_negocios.model.dto.RegisterResponse;
import ec.akira.akira_negocios.model.entity.Employee;
import ec.akira.akira_negocios.model.entity.Person;
import ec.akira.akira_negocios.model.entity.User;
import ec.akira.akira_negocios.model.enumEntity.StatusEmployee;
import ec.akira.akira_negocios.repository.EmployeeRepo;
import ec.akira.akira_negocios.repository.PersonRepo;
import ec.akira.akira_negocios.repository.UserRepo;
import ec.akira.akira_negocios.service.AuthService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

        private final UserRepo userRepository;
        private final PersonRepo personRepository;
        private final EmployeeRepo employeeRepository;
        private final JwtService jwtService;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;

        @Override
        public AuthResponse login(LoginResponse loginResponse) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                loginResponse.getUsername(), loginResponse.getPassword()));

                User user = userRepository.findByUsername(loginResponse.getUsername())
                                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

                Employee employee = user.getEmployee();
                Person person = (employee != null) ? employee.getPerson() : null;

                String personName = (person != null)
                                ? person.getFirstName() + " " + person.getLastName()
                                : "Usuario sin persona asociada";

                String token = jwtService.getToken((UserDetails) user);

                return AuthResponse.builder()
                                .token(token)
                                .userName(personName)
                                .build();
        }

        @Override
        public AuthResponse register(RegisterResponse registerResponse) {

                Person person = personRepository.findByIdentification(registerResponse.getPerson().getIdentification());

                Employee employee = Employee.builder()
                                .position(registerResponse.getEmployee().getPosition())
                                .salary(registerResponse.getEmployee().getSalary())
                                .hireDate(LocalDate.now())
                                .status(StatusEmployee.ACTIVO)
                                .person(person)
                                .build();

                employeeRepository.save(employee);

                User user = User.builder()
                                .username(registerResponse.getUser().getUsername())
                                .password(passwordEncoder.encode(registerResponse.getUser().getPassword()))
                                .role(registerResponse.getUser().getRole())
                                .employee(employee)
                                .build();

                userRepository.save(user);

                String token = jwtService.getToken((UserDetails) user);

                return AuthResponse.builder()
                                .token(token)
                                .userName(person.getFirstName() + " " + person.getLastName())
                                .build();
        }

}
