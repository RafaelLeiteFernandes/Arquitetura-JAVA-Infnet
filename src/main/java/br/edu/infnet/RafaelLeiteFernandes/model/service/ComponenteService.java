package br.edu.infnet.RafaelLeiteFernandes.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.Componente;
import br.edu.infnet.RafaelLeiteFernandes.model.repository.ComponenteRepository;

@Service
public class ComponenteService {
    
    @Autowired
    private ComponenteRepository componenteRepository;
    
    public void incluir(Componente componente) {
        componenteRepository.save(componente);
    }
    
    public List<Componente> obterListaPorPreco(Double precoInicial, Double precoFinal) {
        return componenteRepository.findByPrecoBetween(precoInicial, precoFinal);
    }
}