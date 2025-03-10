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
@Table(name = "supplier")
public class Supplier extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "supplier_id")
    @Comment("Identificador del proveedor")
    private Long supplierId;

    @Column(nullable = true, name = "payment_terms", length = 150)
    @Comment("Terminos de pago del proveedor")
    private String paymentTerms;

    @Column(nullable = false, name = "credit_days")
    @Comment("Dias de credito del proveedor")
    private int creditDays;

    @Column(nullable = false, name = "company_name", length = 150)
    @Comment("Nombre de la empresa del proveedor")
    private String companyName;
}
