package br.edu.infnet.RafaelLeiteFernandes.model.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.Componente;

@Repository
public interface ComponenteRepository extends CrudRepository<Componente, Integer> {
    List<Componente> findByPrecoBetween(Double precoInicial, Double precoFinal);
    List<Componente> findByNomeContaining(String nome);
    List<Componente> findByFornecedorContaining(String fornecedor);
    List<Componente> findByDataFabricacao(Date dataFabricacao);
}