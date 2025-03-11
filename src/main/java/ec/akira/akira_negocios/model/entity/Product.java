package ec.akira.akira_negocios.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import ec.akira.akira_negocios.auditable.Auditable;
import ec.akira.akira_negocios.model.enumEntity.TypeProductEnum;
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
@Table(name = "product")
public class Product extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    @Comment("Identificador del Producto")
    private Long productId;

    @Column(nullable = false, name = "name", length = 25)
    @Comment("Nombre del Producto")
    private String name;

    @Column(nullable = false, name = "description", length = 50)
    @Comment("Descripcion del Producto")
    private String description;

    @Column(nullable = true, name = "purchase_price", columnDefinition = "DECIMAL(10,2)")
    @Comment("Precio de compra del Producto")
    private BigDecimal purchasePrice;

    @Column(nullable = false, name = "retail_price", columnDefinition = "DECIMAL(10,2)")
    @Comment("Precio de venta del Producto")
    private BigDecimal retailPrice;

    @Column(nullable = true, name = "wholesale_price", columnDefinition = "DECIMAL(10,2)")
    @Comment("Precio de venta Mayorista del Producto")
    private BigDecimal wholesale_price;

    @Column(nullable = true, name = "expiration_date")
    @Comment("Fecha de expiracion del Producto")
    private LocalDate expirationDate;

    @Column(nullable = true, name = "image", length = 100)
    @Comment("Imagen del Producto")
    private String image;

    @Column(nullable = true, name = "barcode", length = 100, unique = true)
    @Comment("Codigo de barras del Producto")
    private String barcode;

    @Column(nullable = false, name = "type", length = 25)
    @Comment("Tipo de Producto (NORMAL, SUBPRODUCTO, COMBO)")
    @Enumerated(EnumType.STRING)
    private TypeProductEnum type;

    @Column(nullable = false, name = "minimum_stock", length = 25)
    @Comment("Alerta de stock minimo del Producto")
    private String minimum_stock;

    /*
     * RELACION MUCHOS A UNO CON: SUPPLIER
     */
    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    @JsonBackReference
    private Supplier supplier;

    /*
     * RELACION MUCHOS A UNO CON: CATEGORY
     */
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private Category category;

    /*
     * RELACION UNO A MUCHOS CON: INVENTORY_MOVEMENTS
     */
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<InventoryMovement> inventoryMovements;

    /*
     * RELACION UNO A MUCHOS CON: BRANCH_PRODUCTS
     */
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<BranchProduct> branchProducts;

    /*
     * RELACION UNO A MUCHOS CON: SALE_DETAIL
     */
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<SaleDetail> saleDetails;

    /*
     * RELACION UNO A MUCHOS CON: SUB_PRODUCT (PADRE)
     */
    @OneToMany(mappedBy = "parentProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<SubProduct> parentSubProducts;

    /*
     * RELACION UNO A MUCHOS CON: SUB_PRODUCT (HIJO)
     */
    @OneToMany(mappedBy = "childProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<SubProduct> ChildSubProducts;

    /*
     * RELACION UNO A MUCHOS CON: COMBO_PRODUCT (PADRE)
     */
    @OneToMany(mappedBy = "comboProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ComboProduct> comboProduct;

    /*
     * RELACION UNO A MUCHOS CON: COMBO_PRODUCT (HIJO)
     */
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ComboProduct> simpleProducts;

}
