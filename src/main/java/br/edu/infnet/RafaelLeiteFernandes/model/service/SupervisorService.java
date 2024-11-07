package br.edu.infnet.RafaelLeiteFernandes.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.Supervisor;
import br.edu.infnet.RafaelLeiteFernandes.model.repository.SupervisorRepository;

@Service
public class SupervisorService {
    
    @Autowired
    private SupervisorRepository supervisorRepository;
    
    public void incluir(Supervisor supervisor) {
        supervisorRepository.save(supervisor);
    }
    
    public List<Supervisor> obterLista(){
        return (List<Supervisor>) supervisorRepository.findAll();
    }

    public List<Supervisor> obterPorNome(String nome) {
        return supervisorRepository.findByNomeContaining(nome);
    }

    public List<Supervisor> obterPorExperiencia(int experiencia) {
        return supervisorRepository.findByExperiencia(experiencia);
    }

    public List<Supervisor> obterPorCertificacao(String certificacao) {
        return supervisorRepository.findByCertificacaoContaining(certificacao);
    }

    public List<Supervisor> obterPorIdade(int idade) {
        return supervisorRepository.findByIdade(idade);
    }

    public void excluir(Integer id) {
        supervisorRepository.deleteById(id);
    }

    public void atualizar(Integer id, Supervisor supervisor) {
        if (supervisorRepository.existsById(id)) {
            supervisor.setId(id);
            supervisorRepository.save(supervisor);
        }
    }
}