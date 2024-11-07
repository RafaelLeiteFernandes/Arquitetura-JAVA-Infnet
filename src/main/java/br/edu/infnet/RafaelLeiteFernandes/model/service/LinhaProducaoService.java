package br.edu.infnet.RafaelLeiteFernandes.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.Componente;
import br.edu.infnet.RafaelLeiteFernandes.model.domain.LinhaProducao;
import br.edu.infnet.RafaelLeiteFernandes.model.domain.Supervisor;
import br.edu.infnet.RafaelLeiteFernandes.model.repository.ComponenteRepository;
import br.edu.infnet.RafaelLeiteFernandes.model.repository.LinhaProducaoRepository;
import br.edu.infnet.RafaelLeiteFernandes.model.repository.SupervisorRepository;

@Service
public class LinhaProducaoService {
    
    @Autowired
    private LinhaProducaoRepository linhaProducaoRepository;

    @Autowired
    private ComponenteRepository componenteRepository;

    @Autowired
    private SupervisorRepository supervisorRepository;
    
    @Transactional
    public LinhaProducao incluir(LinhaProducao linhaDeProducao) {
        // Salvar supervisor primeiro
        Supervisor supervisor = linhaDeProducao.getSupervisor();
        if (supervisor != null) {
            if (supervisor.getId() != null) {
                supervisor = supervisorRepository.findById(supervisor.getId()).orElse(supervisor);
            } else {
                supervisor = supervisorRepository.save(supervisor);
            }
        }
        linhaDeProducao.setSupervisor(supervisor);

        // Salvar componentes primeiro
        for (Componente componente : linhaDeProducao.getComponentes()) {
            componenteRepository.save(componente);
        }
        
        // Salvar linha de produção
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

    @Transactional
    public LinhaProducao atualizar(Integer id, LinhaProducao linhaProducao) {
        if (linhaProducaoRepository.existsById(id)) {
            LinhaProducao linhaExistente = linhaProducaoRepository.findById(id).orElse(null);
            if (linhaExistente != null) {
                linhaExistente.setIdentificador(linhaProducao.getIdentificador());
                linhaExistente.setStatus(linhaProducao.getStatus());
                linhaExistente.setDataInicio(linhaProducao.getDataInicio());
                linhaExistente.setDataFimPrevisto(linhaProducao.getDataFimPrevisto());
                linhaExistente.setCustoOperacional(linhaProducao.getCustoOperacional());
                return linhaProducaoRepository.save(linhaExistente);
            }
        }
        return null;
    }

    @Transactional
    public void excluir(Integer id) {
        linhaProducaoRepository.deleteById(id);
    }
}