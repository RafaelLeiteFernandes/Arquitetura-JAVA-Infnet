package br.edu.infnet.RafaelLeiteFernandes.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.LinhaProducao;

@Repository
public interface LinhaProducaoRepository extends CrudRepository<LinhaProducao, Integer> {
	
}
