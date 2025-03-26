package ec.akira.akira_negocios.model.dto;

import java.time.LocalDate;
import java.util.List;

import ec.akira.akira_negocios.model.entity.Person;
import ec.akira.akira_negocios.model.entity.User;
import ec.akira.akira_negocios.model.enumEntity.StatusEmployee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {
    private Long employeeId;
    private String position;
    private String salary;
    private LocalDate hireDate;
    private StatusEmployee status;
    private Person person;
    private List<User> users;
}
