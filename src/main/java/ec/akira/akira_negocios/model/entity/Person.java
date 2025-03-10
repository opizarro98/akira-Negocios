package ec.akira.akira_negocios.model.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.Comment;

import ec.akira.akira_negocios.auditable.Auditable;
import ec.akira.akira_negocios.model.enumEntity.TypePersonEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "person")
public class Person extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    @Comment("Identificador de la persona")
    private Long personId;

    @Column(nullable = false, name = "identification", length = 15)
    @Comment("Cedula, Ruc o Pasaportede la persona")
    private String identification;

    @Column(nullable = false, name = "first_name", length = 25)
    @Comment("Primer nombre de la persona")
    private String firstName;

    @Column(nullable = true, name = "middle_name", length = 25)
    @Comment("Segundo nombre de la persona")
    private String middleName;

    @Column(nullable = false, name = "last_name", length = 25)
    @Comment("Primer apellido de la persona")
    private String lastName;

    @Column(nullable = true, name = "second_last_name", length = 25)
    @Comment("Segundo apellido de la persona")
    private String secondLastName;

    @Column(nullable = false, name = "landline_phone", length = 10)
    @Comment("Telefono convencional de la persona")
    private String landlinePhone;

    @Column(nullable = false, name = "mobile_phone", length = 10)
    @Comment("Telefono celular de la persona")
    private String mobilePhone;

    @Column(nullable = false, name = "email", length = 50)
    @Comment("Email de la persona")
    private String email;

    @Column(nullable = false, name = "address", length = 100)
    @Comment("Direccion del domicilio de la persona")
    private String address;

    @Column(nullable = false, name = "type")
    @Comment("Tipo de persona")
    @Enumerated(EnumType.STRING)
    private TypePersonEnum type;

    @Column(nullable = false, name = "total_debt", columnDefinition = "DECIMAL(10,2)")
    @Comment("Total que tiene la persona en debito")
    private BigDecimal totalDebt;

}
