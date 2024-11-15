package br.edu.infnet.RafaelLeiteFernandes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.Supervisor;
import br.edu.infnet.RafaelLeiteFernandes.model.service.SupervisorService;

@RestController
@RequestMapping("/supervisores")
public class SupervisorController {
    
    @Autowired
    private SupervisorService supervisorService;
    
    @GetMapping(value = "/filtrarPorNome/{nome}")
    public List<Supervisor> obterPorNome(@PathVariable String nome) {
        return supervisorService.obterPorNome(nome);
    }
    
    @GetMapping(value = "/all")
    public List<Supervisor> obterLista(){
        return supervisorService.obterLista();
    }

    @GetMapping(value = "/filtrarPorExperiencia/{experiencia}")
    public List<Supervisor> obterPorExperiencia(@PathVariable int experiencia) {
        return supervisorService.obterPorExperiencia(experiencia);
    }

    @GetMapping(value = "/filtrarPorCertificacao/{certificacao}")
    public List<Supervisor> obterPorCertificacao(@PathVariable String certificacao) {
        return supervisorService.obterPorCertificacao(certificacao);
    }

    @PostMapping(value = "/incluir")
    public void incluir(@Valid @RequestBody Supervisor supervisor) {
        supervisorService.incluir(supervisor);
    }

    @DeleteMapping(value = "/excluir/{id}")
    public void excluir(@PathVariable Integer id) {
        supervisorService.excluir(id);
    }

    @PutMapping(value = "/atualizar/{id}")
    public void atualizar(@PathVariable Integer id, @Valid @RequestBody Supervisor supervisor) {
        supervisorService.atualizar(id, supervisor);
    }
}