package br.edu.infnet.RafaelLeiteFernandes.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.LinhaProducao;
import br.edu.infnet.RafaelLeiteFernandes.model.service.LinhaProducaoService;

@RestController
public class LinhaProducaoController {
	
	@Autowired
	private LinhaProducaoService linhaProducaoService;
	
	@GetMapping(value = "/lista/LinhaProducao")
	public Collection<LinhaProducao> obterLista(){
		return linhaProducaoService.obterLista();
	}
}