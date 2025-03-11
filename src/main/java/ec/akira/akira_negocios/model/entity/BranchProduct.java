package ec.akira.akira_negocios.model.entity;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ec.akira.akira_negocios.auditable.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "branch_product")
public class BranchProduct extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "branchproduct_id")
    @Comment("Identificador del producto la sucursal")
    private Long branchProductId;

    @Column(nullable = false, name = "stock")
    @Comment("Stock general del producto")
    private int stock;

    /*
     * ****************************** RELACIONES ********************************
     */

    /*
     * RELACION MUCHOS A UNO CON: PRODUCT
     */
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonBackReference
    private Product product;

    /*
     * RELACION MUCHOS A UNO CON: BRANCH
     */
    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    @JsonBackReference
    private Branch branch;

}
