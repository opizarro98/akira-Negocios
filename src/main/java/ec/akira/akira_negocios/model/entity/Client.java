package ec.akira.akira_negocios.model.entity;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import ec.akira.akira_negocios.auditable.Auditable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "client")
public class Client extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    @Comment("Identificador de cliente")
    private Long clientId;

    @Column(nullable = true, name = "credit_limit", columnDefinition = "DECIMAL(10,2)")
    @Comment("Limite de credito que tiene la persona")
    private BigDecimal credit_limit;

    @Column(nullable = true, name = "current_debt", columnDefinition = "DECIMAL(10,2)")
    @Comment("Deuda actual que tiene la persona")
    private BigDecimal current_debt;

    @Column(nullable = true, name = "total_debt", columnDefinition = "DECIMAL(10,2)")
    @Comment("Total que tiene la persona en debito")
    private BigDecimal totalDebt;

    /*
     * RELACION MUCHOS A UNO CON: PERSON
     */
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    @JsonBackReference
    private Person person;

    /*
     * RELACION DE UNO A MUCHO CON: SALE
     */
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Sale> sales;

    /*
     * RELACION DE UNO A MUCHO CON: CLIENT_DEBT
     */
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ClientDebt> clientDebts;

}
