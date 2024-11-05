package br.edu.infnet.RafaelLeiteFernandes.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.LinhaProducao;
import br.edu.infnet.RafaelLeiteFernandes.model.service.LinhaProducaoService;

@RestController
public class LinhaProducaoController {
    
    @Autowired
    private LinhaProducaoService linhaProducaoService;
    
    @GetMapping(value = "linha/lista/LinhaProducao")
    public Collection<LinhaProducao> obterLista(){
        return linhaProducaoService.obterLista();
    }
    
    @GetMapping(value = "linha/identificadores/buscar/{identificador}" )
    public List<LinhaProducao> obterPorIdentificador(@PathVariable String identificador) {
        return linhaProducaoService.obterPorIdentificador(identificador);
    }

    @GetMapping(value = "linha/status/buscar/{status}" )
    public List<LinhaProducao> obterPorStatus(@PathVariable String status) {
        return linhaProducaoService.obterPorStatus(status);
    }

}