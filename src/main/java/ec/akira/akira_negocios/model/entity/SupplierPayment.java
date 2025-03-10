package ec.akira.akira_negocios.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.Comment;

import ec.akira.akira_negocios.auditable.Auditable;
import ec.akira.akira_negocios.model.enumEntity.PaymentMethodEnum;
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
@Table(name = "supplier_payment")
public class SupplierPayment extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "supplier_payment_id")
    @Comment("Identificador del pago al proveedor")
    private Long supplierPaymentId;

    @Column(nullable = false, name = "payment_method")
    @Comment("Metodo de pago con el que se hace el pago al proveedor")
    @Enumerated(EnumType.STRING)
    private PaymentMethodEnum paymentMethod;

    @Column(nullable = false, name = "amount", columnDefinition = "DECIMAL(10,2)")
    @Comment("Monto que se paga al proveedor")
    private BigDecimal amount;

    @Column(nullable = false, name = "date")
    @Comment("Fecha del pago al proveedor")
    private LocalDate date;

}
