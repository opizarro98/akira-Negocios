package ec.akira.akira_negocios.model.entity;

import org.hibernate.annotations.Comment;

import ec.akira.akira_negocios.auditable.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "people")
public class People extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    @Comment("identificador de la persona")
    private Long personId;

    @Column(nullable = false, name = "identification", length = 15)
    @Comment("Cedula, Ruc o Pasaportede la persona")
    private String identification;

    @Column(nullable = false, name = "first_name", length = 25)
    @Comment("Primer nombre de la persona")
    private String firstName;

    @Column(nullable = true, name = "second_name", length = 25)
    @Comment("Segundo nombre de la persona")
    private String secondName;

    @Column(nullable = false, name = "first_surname", length = 25)
    @Comment("Primer apellido de la persona")
    private String firstSurname;

    @Column(nullable = true, name = "second_surname", length = 25)
    @Comment("Segundo apellido de la persona")
    private String secodSurname;

    @Column(nullable = false, name = "home_number", length = 10)
    @Comment("Telefono convencional de la persona")
    private String homeNumber;

    @Column(nullable = false, name = "phone_number", length = 10)
    @Comment("Telefono celular de la persona")
    private String phoneNumber;

    @Column(nullable = false, name = "email", length = 50)
    @Comment("Email de la persona")
    private String email;

    @Column(nullable = false, name = "address", length = 100)
    @Comment("Direccion del domicilio de la persona")
    private String address;

}
