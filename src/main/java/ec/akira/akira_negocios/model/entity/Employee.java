package ec.akira.akira_negocios.model.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import ec.akira.akira_negocios.auditable.Auditable;
import ec.akira.akira_negocios.model.enumEntity.StatusEmployee;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@Table(name = "employee")
public class Employee extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    @Comment("Identificador del empleado")
    private Long employeeId;

    @Column(nullable = false, name = "position", length = 150)
    @Comment("Cargo del empleado")
    private String position;

    @Column(nullable = false, name = "salary", length = 150)
    @Comment("Salario del empleado")
    private String salary;

    @Column(nullable = false, name = "hire_date", length = 150)
    @Comment("Fecha de contratacion del empleado")
    private LocalDate hireDate;

    @Column(nullable = false, name = "status", length = 150)
    @Comment("Estado del empleado")
    @Enumerated(EnumType.STRING)
    private StatusEmployee status;

    /*
     * RELACION MUCHOS A UNO CON: PERSON
     */
    @ManyToOne
    @JoinColumn(name = "personId", nullable = false)
    @JsonBackReference
    private Person person;

    /*
     * RELACION UNO A MUCHOS CON: SALE
     */
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Sale> sales;

    /*
     * RELACION UNO A MUCHOS CON: USER
     */
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<User> users;

}
