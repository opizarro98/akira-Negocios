package ec.akira.akira_negocios.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    @Column(nullable = false, name = "purchase_price", precision = 10, scale = 2)
    @Comment("Precio de compra del Producto")
    private BigDecimal purchasePrice;

    @Column(nullable = false, name = "retail_price", precision = 10, scale = 2)
    @Comment("Precio de venta del Producto")
    private BigDecimal retailPrice;

    @Column(nullable = false, name = "wholesale_price", precision = 10, scale = 2)
    @Comment("Precio de venta Mayorista del Producto")
    private BigDecimal wholesale_price;

    @Column(nullable = false, name = "expiration_date")
    @Comment("Fecha de expiracion del Producto")
    private LocalDate expirationDate;

    @Column(nullable = false, name = "image", length = 100)
    @Comment("Imagen del Producto")
    private String image;

    @Column(nullable = false, name = "barcode", length = 100, unique = true)
    @Comment("Codigo de barras del Producto")
    private String barcode;

    @Column(nullable = false, name = "type", length = 25)
    @Comment("Tipo de Producto (NORMAL, SUBPRODUCTO, COMBO)")
    private String type;

    @Column(nullable = false, name = "minimum_stock", length = 25)
    @Comment("Alerta de stock minimo del Producto")
    private String minimum_stock;

}
