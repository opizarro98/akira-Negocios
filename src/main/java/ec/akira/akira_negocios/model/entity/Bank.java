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
@Table(name = "bank")
public class Bank extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bank_id")
    @Comment("identificador del banco")
    private Long bankId;

    @Column(nullable = false, name = "first_name", length = 25)
    @Comment("Primer nombre del banco")
    private String name;
}
