package br.edu.infnet.RafaelLeiteFernandes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.ComponenteEletronico;
import br.edu.infnet.RafaelLeiteFernandes.model.service.ComponenteEletronicoService;

@RestController
@RequestMapping("/componentes/eletronicos")
public class ComponenteEletronicoController {
    
    @Autowired
    private ComponenteEletronicoService componenteEletronicoService;
    
    @GetMapping("/{id}")
    public ComponenteEletronico obterPorId(@PathVariable Integer id) {
        return componenteEletronicoService.obterPorId(id);
    }
    
    @GetMapping
    public List<ComponenteEletronico> obterTodos() {
        return componenteEletronicoService.obterTodos();
    }
    
    @PostMapping
    public void incluir(@Valid @RequestBody ComponenteEletronico componenteEletronico) {
        componenteEletronicoService.incluir(componenteEletronico);
    }
    
    @PutMapping("/{id}")
    public void atualizar(@PathVariable Integer id, @Valid @RequestBody ComponenteEletronico componenteEletronico) {
        componenteEletronicoService.atualizar(id, componenteEletronico);
    }
    
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        componenteEletronicoService.excluir(id);
    }
}