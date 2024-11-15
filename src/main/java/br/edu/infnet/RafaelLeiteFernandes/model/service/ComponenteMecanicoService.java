package br.edu.infnet.RafaelLeiteFernandes.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.ComponenteMecanico;
import br.edu.infnet.RafaelLeiteFernandes.model.repository.ComponenteMecanicoRepository;

@Service
public class ComponenteMecanicoService {
    
    @Autowired
    private ComponenteMecanicoRepository componenteMecanicoRepository;
    
    public ComponenteMecanico obterPorId(Integer id) {
        return componenteMecanicoRepository.findById(id).orElse(null);
    }
    
    public List<ComponenteMecanico> obterTodos() {
        return (List<ComponenteMecanico>) componenteMecanicoRepository.findAll();
    }
    
    public void incluir(ComponenteMecanico componenteMecanico) {
        componenteMecanicoRepository.save(componenteMecanico);
    }
    
    public void atualizar(Integer id, ComponenteMecanico componenteMecanico) {
        if (componenteMecanicoRepository.existsById(id)) {
            componenteMecanico.setId(id);
            componenteMecanicoRepository.save(componenteMecanico);
        }
    }
    
    public void excluir(Integer id) {
        componenteMecanicoRepository.deleteById(id);
    }
}