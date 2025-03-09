package ec.akira.akira_negocios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.akira.akira_negocios.model.entity.Branch;

@Repository
public interface BranchRepo extends JpaRepository<Branch, Long> {

}
