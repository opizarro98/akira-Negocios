package ec.akira.akira_negocios.model.entity;

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

@Entity
@Table(name = "companies")
@Getter
@Setter
public class Companies extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
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
    @Comment("el logotipo de la empresa")
    private String logo;

    @Column(nullable = true, name = "iva", length = 10)
    @Comment("Impuesto que maneja la empresa")
    private String iva;

}
