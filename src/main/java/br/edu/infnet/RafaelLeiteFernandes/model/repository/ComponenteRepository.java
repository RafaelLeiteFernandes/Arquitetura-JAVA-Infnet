package br.edu.infnet.RafaelLeiteFernandes.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.Componente;

@Repository
public interface ComponenteRepository extends CrudRepository<Componente, Integer> {

}
