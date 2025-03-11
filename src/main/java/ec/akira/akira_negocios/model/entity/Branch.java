package ec.akira.akira_negocios.model.entity;

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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "branch")
public class Branch extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "branches_id")
    @Comment("Identificador de la sucursal")
    private Long branchId;

    @Column(nullable = false, name = "name", length = 150)
    @Comment("Nombre de la sucursal")
    private String name;

    @Column(nullable = false, name = "address", length = 50)
    @Comment("Direccion del sucursal")
    private String address;

    @Column(nullable = true, name = "conventional_Phone", length = 10)
    @Comment("Numero convencional de la sucursal")
    private String conventionalPhone;

    @Column(nullable = true, name = "mobile_phone", length = 10)
    @Comment("Numero celular de la sucursal")
    private String mobilePhone;

    /*
     * RELACION UNO A MUCHOS CON: USER
     */
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<User> user;

    /*
     * RELACION MUCHOS A UNO CON: COMPANY
     */
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    @JsonBackReference
    private Company company;

    /*
     * RELACION UNO A MUCHOS CON: BRANCH_PRODUCTS
     */
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<BranchProduct> branchProducts;

    /*
     * RELACION UNO A MUCHOS CON: SALE
     */
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Sale> sales;

    /*
     * RELACION UNO A MUCHOS CON: Inventory_Movement
     */
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<InventoryMovement> inventoryMovements;

}
