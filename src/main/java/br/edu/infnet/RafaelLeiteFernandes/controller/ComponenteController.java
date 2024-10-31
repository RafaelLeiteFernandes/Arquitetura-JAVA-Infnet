package br.edu.infnet.RafaelLeiteFernandes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.Componente;
import br.edu.infnet.RafaelLeiteFernandes.model.service.ComponenteService;

@RestController
public class ComponenteController {
	
	@Autowired
	private ComponenteService componenteService;
	
	@GetMapping(value = "/componentes/filtrarPorPreco/{min}/{max}")
	public List<Componente> obterListaPorPreco(@PathVariable Double min, @PathVariable Double max) {
		return componenteService.obterListaPorPreco(min, max);
	}	
}