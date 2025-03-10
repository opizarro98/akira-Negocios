package ec.akira.akira_negocios.model.entity;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ec.akira.akira_negocios.auditable.Auditable;
import ec.akira.akira_negocios.model.enumEntity.RolUserEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    @Comment("Identificador del usuario")
    private Long userId;

    @Column(nullable = false, name = "identification", length = 15)
    @Comment("Nombre de usuario para el inicio de sesion")
    private String username;

    @Column(nullable = false, name = "first_name", length = 25)
    @Comment("Contrasena del usuario")
    private String password;

    @Column(nullable = true, name = "second_name")
    @Comment("Rol de la persona")
    @Enumerated(EnumType.STRING)
    private RolUserEnum role;

    @ManyToOne
    @JoinColumn(name = "personId", nullable = false)
    @JsonBackReference
    private Person person;
}
