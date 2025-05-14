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
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    @Comment("identificador el rol de la persona")
    private Long roleId;

    @Column(nullable = false, name = "role_name", length = 25)
    @Comment("Nombre del rol")
    private String name;

    @Column(nullable = false, name = "role_description", length = 25)
    @Comment("Descripcion del rol")
    private String description;

    /*
     * RELACION UNO A MUCHOS CON: USErROLE
     */
    // @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch =
    // FetchType.EAGER)
    // @JsonManagedReference
    // private String userRoles;
}
