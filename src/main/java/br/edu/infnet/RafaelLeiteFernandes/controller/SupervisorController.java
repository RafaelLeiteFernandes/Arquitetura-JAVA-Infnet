package br.edu.infnet.RafaelLeiteFernandes.controller;

import java.util.List;

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

    @GetMapping(value = "/filtrarPorExperiencia/{experiencia}")
    public List<Supervisor> obterPorExperiencia(@PathVariable int experiencia) {
        return supervisorService.obterPorExperiencia(experiencia);
    }

    @GetMapping(value = "/filtrarPorCertificacao/{certificacao}")
    public List<Supervisor> obterPorCertificacao(@PathVariable String certificacao) {
        return supervisorService.obterPorCertificacao(certificacao);
    }

    @GetMapping(value = "/filtrarPorIdade/{idade}")
    public List<Supervisor> obterPorIdade(@PathVariable int idade) {
        return supervisorService.obterPorIdade(idade);
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Supervisor supervisor) {
        supervisorService.incluir(supervisor);
    }
}