package ec.akira.akira_negocios.model.entity;

import java.util.List;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import ec.akira.akira_negocios.auditable.Auditable;
import ec.akira.akira_negocios.model.enumEntity.BankAccountEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    /*
     * RELACION MUCHOS AUNO CON: BANK
     */
    @ManyToOne
    @JoinColumn(name = "bank_id", nullable = false)
    @JsonBackReference
    private Bank bank;

    /*
     * RELACION UNO A MUCHO CON: SUPLAIER_PAYMENT
     */
    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<SupplierPayment> supplierPayments;

    /*
     * RELACION UNO A MUCHO CON: BANK_ACCOUNT
     */
    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<SalePayment> salePayments;

}
