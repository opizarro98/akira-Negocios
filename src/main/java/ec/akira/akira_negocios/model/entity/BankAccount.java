package ec.akira.akira_negocios.model.entity;

import org.hibernate.annotations.Comment;

import ec.akira.akira_negocios.auditable.Auditable;
import ec.akira.akira_negocios.model.enumEntity.BankAccountEnum;
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
@Table(name = "bank_account")
public class BankAccount extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bank_account_id")
    @Comment("Identificador de la cuneta de banco")
    private Long bankAccountId;

    @Column(name = "account_number", nullable = false, length = 25)
    @Comment("Numero de cuenta de banco")
    private String accountNumber;

    @Column(name = "type", nullable = false)
    @Comment("Tipo de cuenta de banco (Ahorros o Correinte)")
    @Enumerated(EnumType.STRING)
    private BankAccountEnum type;
}
