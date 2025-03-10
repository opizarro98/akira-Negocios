package ec.akira.akira_negocios.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.Comment;

import ec.akira.akira_negocios.auditable.Auditable;
import ec.akira.akira_negocios.model.enumEntity.StatusSaleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sale")
public class Sale extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sale_id")
    @Comment("Identificador de la venta")
    private Long saleId;

    @Column(nullable = false, name = "date")
    @Comment("Fecha de la compra")
    private LocalDate date;

    @Column(nullable = false, name = "total")
    @Comment("Valor total de la compra")
    private BigDecimal total;

    @Column(nullable = false, name = "iva")
    @Comment("IVA agregado a la compra")
    private int iva;

    @Column(nullable = false, name = "total_discount")
    @Comment("Total de descuento aplicado a la compra")
    private int total_discount;

    @Column(nullable = true, name = "remarks")
    @Comment("Observaciones de la compra")
    private String remarks;

    @Column(nullable = false, name = "status")
    @Comment("Estado de la compra (CONTADO O CREDITO)")
    @Enumerated(EnumType.STRING)
    private StatusSaleEnum status;
}
