package ec.akira.akira_negocios.model.entity;

import java.math.BigDecimal;

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
@Table(name = "sale_detail")
public class SaleDetail extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sale_detail_id")
    @Comment("Identificador del deatlle de la venta")
    private Long saleDetailId;

    @Column(nullable = false, name = "quantity")
    @Comment("Cantidad del produto en el detalle de la venta")
    private int quantity;

    @Column(nullable = false, name = "unit_price")
    @Comment("Precion unitario del producto")
    private BigDecimal unitPrice;

    @Column(nullable = false, name = "discount", columnDefinition = "DECIMAL(10,2) DEFAULT 0.0")
    @Comment("Descuento individual del producto")
    private BigDecimal discount;

    @Column(nullable = false, name = "subtotal")
    @Comment("Subtotal del producto")
    private BigDecimal subtotal;
}
