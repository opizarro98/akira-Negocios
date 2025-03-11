package ec.akira.akira_negocios.model.entity;

import java.util.List;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import ec.akira.akira_negocios.auditable.Auditable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bank")
public class Bank extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bank_id")
    @Comment("identificador del banco")
    private Long bankId;

    @Column(nullable = false, name = "first_name", length = 25)
    @Comment("Primer nombre del banco")
    private String name;

    /*
     * RELACION UNO A MUCHOS CON: BANK_ACCOUNT
     */
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<BankAccount> bankAccounts;

    /*
     * RELACION UNO A MUCHOS CON: SUPPLAIR_PAYMENT
     */
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<SupplierPayment> supplierPayments;

    /*
     * RELACION UNO A MUCHOS CON: SALE_PAYMENTS
     */
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<SalePayment> salePayments;
}
