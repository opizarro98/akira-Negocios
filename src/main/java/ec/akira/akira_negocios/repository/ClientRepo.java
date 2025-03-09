package ec.akira.akira_negocios.repository;

import org.springframework.stereotype.Repository;

import ec.akira.akira_negocios.model.entity.Client;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

}
