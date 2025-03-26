package ec.akira.akira_negocios.model.dto;

import java.util.List;

import ec.akira.akira_negocios.model.entity.Branch;
import ec.akira.akira_negocios.model.entity.Employee;
import ec.akira.akira_negocios.model.entity.InventoryMovement;
import ec.akira.akira_negocios.model.enumEntity.RolUserEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private Long userId;
    private String username;
    private String password;
    private RolUserEnum role;
    private Employee employee;
    private Branch branch;
    private List<InventoryMovement> inventoryMovements;
}
