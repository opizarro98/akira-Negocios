package ec.akira.akira_negocios.model.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ec.akira.akira_negocios.auditable.Auditable;
import ec.akira.akira_negocios.model.enumEntity.PaymentMethodEnum;
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

@Getter
@Setter
@Entity
@Table(name = "sale_payment")
public class SalePayment extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sale_payment_id")
    @Comment("Identificador de la forma de pago de la venta")
    private Long salePaymentId;

    @Column(nullable = false, name = "amount", columnDefinition = "DECIMAL(10,2)")
    @Comment("Monto que se paga en la compra")
    private BigDecimal amount;

    @Column(nullable = false, name = "payment_method")
    @Comment("Metodo de pago con el que se hace el pago de la compra")
    @Enumerated(EnumType.STRING)
    private PaymentMethodEnum paymentMethod;

    /*
     * RELACION MUCHOS AUNO CON: SALE
     */
    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    @JsonBackReference
    private Sale sale;

    /*
     * RELACION MUCHOS AUNO CON: BANK
     */
    @ManyToOne
    @JoinColumn(name = "bank_id", nullable = false)
    @JsonBackReference
    private Bank bank;

    /*
     * RELACION MUCHOS AUNO CON: BANK_ACCOUNT
     */
    @ManyToOne
    @JoinColumn(name = "destination_account_id", nullable = false)
    @JsonBackReference
    private BankAccount bankAccount;

}
