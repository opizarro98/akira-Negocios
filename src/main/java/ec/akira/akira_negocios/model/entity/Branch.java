package ec.akira.akira_negocios.model.entity;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ec.akira.akira_negocios.auditable.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @ManyToOne
    @JoinColumn(name = "companyid", nullable = false)
    @JsonBackReference
    private Company company;

}
