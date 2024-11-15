package br.edu.infnet.RafaelLeiteFernandes.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.Componente;
import br.edu.infnet.RafaelLeiteFernandes.model.service.ComponenteService;

@RestController
@RequestMapping("/componentes")
public class ComponenteController {
    
    @Autowired
    private ComponenteService componenteService;
    
    @GetMapping(value = "/filtrarPorPreco/{min}/{max}")
    public List<Componente> obterListaPorPreco(@PathVariable Double min, @PathVariable Double max) {
        return componenteService.obterListaPorPreco(min, max);
    }

    @GetMapping(value = "/filtrarPorNome/{nome}")
    public List<Componente> obterPorNome(@PathVariable String nome) {
        return componenteService.obterPorNome(nome);
    }

    @GetMapping(value = "/filtrarPorFornecedor/{fornecedor}")
    public List<Componente> obterPorFornecedor(@PathVariable String fornecedor) {
        return componenteService.obterPorFornecedor(fornecedor);
    }

    @GetMapping(value = "/filtrarPorDataFabricacao/{dataFabricacao}")
    public List<Componente> obterPorDataFabricacao(@PathVariable String dataFabricacao) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dataFabricacao);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return componenteService.obterPorDataFabricacao(date);
    }
}