package br.edu.infnet.RafaelLeiteFernandes.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.ComponenteMecanico;

@Repository
public interface ComponenteMecanicoRepository extends CrudRepository<ComponenteMecanico, Integer> {

}