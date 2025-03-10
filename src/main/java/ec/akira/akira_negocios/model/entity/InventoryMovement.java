package ec.akira.akira_negocios.model.entity;

import java.time.LocalDate;

import org.hibernate.annotations.Comment;

import ec.akira.akira_negocios.auditable.Auditable;
import ec.akira.akira_negocios.model.enumEntity.TypeInventoryMovementEnum;
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
@Table(name = "inventory_movement")
public class InventoryMovement extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inventory_movement_id")
    @Comment("Identificador del movimiento del inventario")
    private Long inventoryMovementId;

    @Column(nullable = false, name = "type")
    @Comment("Tipo de movieminto (ENTRADA O SALIDA)")
    @Enumerated(EnumType.STRING)
    private TypeInventoryMovementEnum type;

    @Column(nullable = false, name = "quantity")
    @Comment("Cantidad que se realiza el movimeinto")
    private int quantity;

    @Column(nullable = false, name = "date")
    @Comment("Fecha en la que se realiza el movimiento")
    private LocalDate date;

    @Column(nullable = false, name = "reason")
    @Comment("Razon por la que se realiza el movimiento")
    private String reason;
}
