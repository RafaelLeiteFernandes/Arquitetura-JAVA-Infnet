package br.edu.infnet.RafaelLeiteFernandes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.ComponenteMecanico;
import br.edu.infnet.RafaelLeiteFernandes.model.service.ComponenteMecanicoService;

@RestController
@RequestMapping("/componentes/mecanicos")
public class ComponenteMecanicoController {
    
    @Autowired
    private ComponenteMecanicoService componenteMecanicoService;
    
    @GetMapping("/{id}")
    public ComponenteMecanico obterPorId(@PathVariable Integer id) {
        return componenteMecanicoService.obterPorId(id);
    }
    
    @GetMapping
    public List<ComponenteMecanico> obterTodos() {
        return componenteMecanicoService.obterTodos();
    }
    
    @PostMapping
    public void incluir(@RequestBody ComponenteMecanico componenteMecanico) {
        componenteMecanicoService.incluir(componenteMecanico);
    }
    
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        componenteMecanicoService.excluir(id);
    }
}