package ec.akira.akira_negocios.model.entity;

import java.util.Collection;
import java.util.List;

import org.hibernate.annotations.Comment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class User extends Auditable implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    @Comment("Identificador del usuario")
    private Long userId;

    @Column(nullable = false, name = "username", length = 100)
    @Comment("Nombre de usuario para el inicio de sesion")
    private String username;

    @Column(nullable = false, name = "password")
    @Comment("Contrasena del usuario")
    private String password;

    @Column(nullable = false, name = "role")
    @Comment("Rol de la persona")
    @Enumerated(EnumType.STRING)
    private RolUserEnum role;

    /*
     * RELACION MUCHO A UNO CON: PERSON
     */
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = true)
    @JsonBackReference
    private Person person;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((role.name())));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
