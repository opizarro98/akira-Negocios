package ec.akira.akira_negocios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.akira.akira_negocios.model.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    // Custom query methods can be defined here if needed

}
