package br.edu.infnet.RafaelLeiteFernandes.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.LinhaProducao;
import br.edu.infnet.RafaelLeiteFernandes.model.service.LinhaProducaoService;

@RestController
@RequestMapping("/linha")
public class LinhaProducaoController {
    
    @Autowired
    private LinhaProducaoService linhaProducaoService;
    
    @GetMapping(value = "/lista/LinhaProducao")
    public Collection<LinhaProducao> obterLista(){
        return linhaProducaoService.obterLista();
    }
    
    @GetMapping(value = "/identificadores/buscar/{identificador}" )
    public List<LinhaProducao> obterPorIdentificador(@PathVariable String identificador) {
        return linhaProducaoService.obterPorIdentificador(identificador);
    }

    @GetMapping(value = "/status/buscar/{status}" )
    public List<LinhaProducao> obterPorStatus(@PathVariable String status) {
        return linhaProducaoService.obterPorStatus(status);
    }

    @PostMapping(value = "/incluir")
    public LinhaProducao incluir(@RequestBody LinhaProducao linhaProducao) {
        return linhaProducaoService.incluir(linhaProducao);
    }

    @PutMapping(value = "/atualizar/{id}")
    public LinhaProducao atualizar(@PathVariable Integer id, @RequestBody LinhaProducao linhaProducao) {
        return linhaProducaoService.atualizar(id, linhaProducao);
    }

    @DeleteMapping(value = "/excluir/{id}")
    public void excluir(@PathVariable Integer id) {
        linhaProducaoService.excluir(id);
    }
}