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

@Entity
@Table(name = "company")
@Getter
@Setter
public class Company extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    @Comment("Identificador de la empresa")
    private Long companyid;

    @Column(nullable = false, name = "name", length = 150)
    @Comment("Nombre de la empresa")
    private String name;

    @Column(nullable = false, name = "ruc", length = 15)
    @Comment("RUC, RIMPE o identificacion del representante del negocio")
    private String ruc;

    @Column(nullable = false, name = "address", length = 50)
    @Comment("Direccion de la empresa")
    private String address;

    @Column(nullable = true, name = "conventional_Phone", length = 10)
    @Comment("Numero convencional de la empresa")
    private String conventionalPhone;

    @Column(nullable = true, name = "mobile_phone", length = 10)
    @Comment("Numero celular de la empresa")
    private String mobilePhone;

    @Column(nullable = true, name = "logo", length = 10)
    @Comment("Logotipo de la empresa")
    private String logo;

    @Column(nullable = true, name = "iva", length = 10)
    @Comment("Impuesto que maneja la empresa")
    private String iva;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Branch> branches;
}
