package ec.akira.akira_negocios.model.dto;

import java.time.LocalDate;

import ec.akira.akira_negocios.model.enumEntity.RolUserEnum;
import ec.akira.akira_negocios.model.enumEntity.TypePersonEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {
    private String username;
    private String password;
    private TypePersonEnum typePerson;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDate birthdate;
    private String identification;
    private String mobilePhone;
    private String address;
    private RolUserEnum rolUser;
}