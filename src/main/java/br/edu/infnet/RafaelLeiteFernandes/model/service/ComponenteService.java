package br.edu.infnet.RafaelLeiteFernandes.model.service;

import java.util.Date;
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

    public List<Componente> obterPorNome(String nome) {
        return componenteRepository.findByNomeContaining(nome);
    }

    public List<Componente> obterPorFornecedor(String fornecedor) {
        return componenteRepository.findByFornecedorContaining(fornecedor);
    }

    public List<Componente> obterPorDataFabricacao(Date dataFabricacao) {
        return componenteRepository.findByDataFabricacao(dataFabricacao);
    }
}