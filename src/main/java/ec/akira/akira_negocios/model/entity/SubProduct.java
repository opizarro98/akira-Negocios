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
@Table(name = "sub_product")
public class SubProduct extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subproduct_Id")
    @Comment("Identificador del subproducto")
    private Long subProductId;

    @Column(nullable = false, name = "quantity_per_parent")
    @Comment("Cantidad de productos padredel subproducto")
    private int quantityPerParent;
}
