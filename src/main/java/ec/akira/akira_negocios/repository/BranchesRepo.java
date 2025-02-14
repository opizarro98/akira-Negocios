package ec.akira.akira_negocios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.akira.akira_negocios.model.entity.Branches;

@Repository
public interface BranchesRepo extends JpaRepository<Branches, Long> {

}
