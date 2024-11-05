package br.edu.infnet.RafaelLeiteFernandes.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.Supervisor;

@Repository
public interface SupervisorRepository extends CrudRepository<Supervisor, Integer> {
    List<Supervisor> findByNomeContaining(String nome);
    List<Supervisor> findByExperiencia(int experiencia);
    List<Supervisor> findByCertificacaoContaining(String certificacao);
    List<Supervisor> findByIdade(int idade);
}