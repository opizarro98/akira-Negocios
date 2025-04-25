package ec.akira.akira_negocios.model.dto.person;

import java.math.BigDecimal;

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
public class SimplePersonResponse {
    private Long personId;
    private String identification;
    private String firstname;
    private String middleName;
    private String lastname;
    private String secondLastName;
    private String landlinePhone;
    private String mobilePhone;
    private String email;
    private String address;
    private TypePersonEnum typePerson;
    private BigDecimal totalDebt;
}
