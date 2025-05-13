package ec.akira.akira_negocios.model.entity;

import java.util.List;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "employee_role")
public class EmployeeRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_role_id")
    @Comment("identificador del banco")
    private Long employeeRole_id;

    @Column(nullable = false, name = "employee_role_name", length = 25)
    @Comment("Nombre del rol")
    private String name;

    @Column(nullable = false, name = "employee_role_description", length = 25)
    @Comment("Descripcion del rol")
    private String description;

    // Relacion uno a muchos con employee
    @OneToMany(mappedBy = "employeeRole", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Employee> employee;
}
