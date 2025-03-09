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
@Table(name = "category")
public class Category extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    @Comment("Identificador de la categoria del producto")
    private Long categoryId;

    @Column(name = "name", nullable = false, length = 25)
    @Comment("Nombre de la categoria para el producto")
    private String name;
}
