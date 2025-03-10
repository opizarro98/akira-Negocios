package ec.akira.akira_negocios.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.Comment;

import ec.akira.akira_negocios.auditable.Auditable;
import ec.akira.akira_negocios.model.enumEntity.StatusClientDebEnum;
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
@Table(name = "client_debt")
public class ClientDebt extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_debt_id")
    @Comment("Identificador del debito del credito de la persona")
    private Long clientDebtId;

    @Column(nullable = false, name = "pending_amount", columnDefinition = "DECIMAL(10,2)")
    @Comment("Valor pendinte de la compra")
    private BigDecimal pendingAmount;

    @Column(nullable = false, name = "due_date")
    @Comment("Fecha de vencimiento de la deuda pendiente")
    private LocalDate dueDate;

    @Column(nullable = false, name = "status")
    @Comment("Estado en el que se encuentra la deuda (PENDIENTE, PAGADO)")
    @Enumerated(EnumType.STRING)
    private StatusClientDebEnum status;
}
