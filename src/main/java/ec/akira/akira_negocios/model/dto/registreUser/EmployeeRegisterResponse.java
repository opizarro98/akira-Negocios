package ec.akira.akira_negocios.model.dto.registreUser;

import java.math.BigDecimal;
import java.time.LocalDate;

import ec.akira.akira_negocios.model.enumEntity.RolUserEnum;
import ec.akira.akira_negocios.model.enumEntity.StatusEmployee;
import ec.akira.akira_negocios.model.enumEntity.TypePersonEnum;
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
public class EmployeeRegisterResponse {
    // USER
    private String username;
    private String password;
    private RolUserEnum roleUser;

    // PERSON
    private String identification;
    private String firstName;
    private String middleName;
    private String lastName;
    private String secondLastName;
    private String landlinePhone;
    private String mobilePhone;
    private String email;
    private LocalDate birthDate;
    private String address;
    private TypePersonEnum type;

    // EMPLOYEE
    private String position;
    private BigDecimal salary;
    private LocalDate hireDate;
    private StatusEmployee status;

}
