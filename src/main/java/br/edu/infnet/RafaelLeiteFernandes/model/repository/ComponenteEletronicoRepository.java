package br.edu.infnet.RafaelLeiteFernandes.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.ComponenteEletronico;

@Repository
public interface ComponenteEletronicoRepository extends CrudRepository<ComponenteEletronico, Integer> {
    // Métodos específicos para ComponenteEletronico, se necessário
}