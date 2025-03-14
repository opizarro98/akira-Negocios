package ec.akira.akira_negocios.model.entity;

import java.util.List;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import ec.akira.akira_negocios.auditable.Auditable;
import ec.akira.akira_negocios.model.enumEntity.RolUserEnum;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    @Comment("Identificador del usuario")
    private Long userId;

    @Column(nullable = false, name = "username", length = 15)
    @Comment("Nombre de usuario para el inicio de sesion")
    private String username;

    @Column(nullable = false, name = "password")
    @Comment("Contrasena del usuario")
    private String password;

    @Column(nullable = true, name = "role")
    @Comment("Rol de la persona")
    @Enumerated(EnumType.STRING)
    private RolUserEnum role;

    /*
     * RELACION MUCHO A UNO CON: EMPLOYEE
     */
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    @JsonBackReference
    private Employee employee;

    /*
     * RELACION MUCHO A UNO CON: BRANCH
     */
    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    @JsonBackReference
    private Branch branch;

    /*
     * RELACION DE UNO A MUCHO CON: Inventory_Movement
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<InventoryMovement> inventoryMovements;

}
