package ec.akira.akira_negocios.model.entity;

import java.time.LocalDate;

import org.hibernate.annotations.Comment;

import ec.akira.akira_negocios.auditable.Auditable;
import ec.akira.akira_negocios.model.enumEntity.StatusEmployee;
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
}
