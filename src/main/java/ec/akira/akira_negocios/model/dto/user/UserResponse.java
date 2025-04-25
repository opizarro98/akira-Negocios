package ec.akira.akira_negocios.model.dto.user;

import java.math.BigDecimal;
import java.time.LocalDate;

import ec.akira.akira_negocios.model.dto.person.PersonResponse;
import ec.akira.akira_negocios.model.enumEntity.RolUserEnum;
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
public class UserResponse {
    // USER
    private String username;
    private String password;
    private RolUserEnum roleUser;

    // PERSON
    private String identification;
    private String firstname;
    private String middlename;
    private String lastname;
    private String secondlastname;
    private String landlinephone;
    private String mobilePhone;
    private String email;
    private LocalDate birthdate;
    private String address;
    private TypePersonEnum typePerson;
    private BigDecimal totalDebt;
}
