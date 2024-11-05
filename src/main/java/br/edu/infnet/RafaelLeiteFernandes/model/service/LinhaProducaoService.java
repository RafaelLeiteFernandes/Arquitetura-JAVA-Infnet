package br.edu.infnet.RafaelLeiteFernandes.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.LinhaProducao;
import br.edu.infnet.RafaelLeiteFernandes.model.repository.LinhaProducaoRepository;

@Service
public class LinhaProducaoService {
    
    @Autowired
    private LinhaProducaoRepository linhaProducaoRepository;
    
    public LinhaProducao incluir(LinhaProducao linhaDeProducao) {
        return linhaProducaoRepository.save(linhaDeProducao);
    }
    
    public Collection<LinhaProducao> obterLista(){
        return (Collection<LinhaProducao>) linhaProducaoRepository.findAll();
    }
    
    public List<LinhaProducao> obterPorIdentificador(String identificador){
        return linhaProducaoRepository.findByIdentificadorContaining(identificador);
    }

    public List<LinhaProducao> obterPorStatus(String status){
        return linhaProducaoRepository.findByStatus(status);
    }

}