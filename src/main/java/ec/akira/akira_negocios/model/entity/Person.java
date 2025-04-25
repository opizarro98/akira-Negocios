package ec.akira.akira_negocios.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import ec.akira.akira_negocios.auditable.Auditable;
import ec.akira.akira_negocios.model.enumEntity.TypePersonEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(nullable = true, name = "landline_phone", length = 10)
    @Comment("Telefono convencional de la persona")
    private String landlinePhone;

    @Column(nullable = true, name = "mobile_phone", length = 10)
    @Comment("Telefono celular de la persona")
    private String mobilePhone;

    @Column(nullable = false, name = "email", length = 50)
    @Comment("Email de la persona")
    private String email;

    @Column(nullable = false, name = "address", length = 100)
    @Comment("Direccion del domicilio de la persona")
    private String address;

    @Column(nullable = false, name = "birth_date", length = 50)
    @Comment("Fecha de nacimiento de la persona")
    private LocalDate birthDate;

    @Column(nullable = false, name = "type")
    @Comment("Tipo de persona")
    @Enumerated(EnumType.STRING)
    private TypePersonEnum type;

    @Column(nullable = true, name = "total_debt", columnDefinition = "DECIMAL(10,2)")
    @Comment("Total que tiene la persona en debito")
    private BigDecimal totalDebt;

    /*
     * RELACION UNO A MUCHOS CON: USER
     */
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<User> users;

    /*
     * RELACION UNO A MUCHOS CON: SUPPLIER
     */
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Supplier> supplier;

    /*
     * RELACION UNO A MUCHOS CON: CLIENT
     */
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Client> client;

}
