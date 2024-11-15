package br.edu.infnet.RafaelLeiteFernandes.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.ComponenteEletronico;
import br.edu.infnet.RafaelLeiteFernandes.model.repository.ComponenteEletronicoRepository;

@Service
public class ComponenteEletronicoService {
    
    @Autowired
    private ComponenteEletronicoRepository componenteEletronicoRepository;
    
    public ComponenteEletronico obterPorId(Integer id) {
        return componenteEletronicoRepository.findById(id).orElse(null);
    }
    
    public List<ComponenteEletronico> obterTodos() {
        return (List<ComponenteEletronico>) componenteEletronicoRepository.findAll();
    }
    
    public void incluir(ComponenteEletronico componenteEletronico) {
        componenteEletronicoRepository.save(componenteEletronico);
    }
    
    public void atualizar(Integer id, ComponenteEletronico componenteEletronico) {
        if (componenteEletronicoRepository.existsById(id)) {
            componenteEletronico.setId(id);
            componenteEletronicoRepository.save(componenteEletronico);
        }
    }
    
    public void excluir(Integer id) {
        componenteEletronicoRepository.deleteById(id);
    }
}