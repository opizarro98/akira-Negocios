package ec.akira.akira_negocios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.akira.akira_negocios.model.entity.InventoryMovement;

@Repository
public interface InventoryMovementRepo extends JpaRepository<InventoryMovement, Long> {

}
