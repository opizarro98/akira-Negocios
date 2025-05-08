package ec.akira.akira_negocios.service.impl;

import org.springframework.stereotype.Service;

import ec.akira.akira_negocios.model.dto.registreUser.EmployeeRegisterResponse;
import ec.akira.akira_negocios.model.entity.Employee;
import ec.akira.akira_negocios.model.entity.Person;
import ec.akira.akira_negocios.repository.EmployeeRepo;
import ec.akira.akira_negocios.repository.PersonRepo;
import ec.akira.akira_negocios.repository.UserRepo;
import ec.akira.akira_negocios.service.EmployeeService;
import ec.akira.akira_negocios.service.mapper.registerclient.PersonUserRegisterMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final PersonRepo personRepository;

    private final UserRepo userRepository;

    private final EmployeeRepo employeeRepository;

    private final PersonUserRegisterMapper personUserRegisterMapper;

    @Override
    @Transactional
    public EmployeeRegisterResponse createEmployee(EmployeeRegisterResponse employee) {
        // Create person
        Person person = personRepository.save(personUserRegisterMapper.toPersonEmployee(employee));
        // Create USER
        userRepository.save(personUserRegisterMapper.toUserEmployee(employee, person));
        // Create EMPLOYEE
        Employee employeeEntity = Employee.builder()
                .position(employee.getPosition())
                .salary(employee.getSalary())
                .hireDate(employee.getHireDate())
                .status(employee.getStatus())
                .person(person)
                .build();
        employeeRepository.save(employeeEntity);
        return employee;
    }

}
