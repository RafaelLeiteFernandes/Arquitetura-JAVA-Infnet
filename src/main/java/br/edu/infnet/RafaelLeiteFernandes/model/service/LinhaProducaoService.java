package br.edu.infnet.RafaelLeiteFernandes.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.LinhaProducao;

@Service
public class LinhaProducaoService {
	
	private  Map<String, LinhaProducao> mapaLinhaProducao = new HashMap<String, LinhaProducao>();
	
	public void incluir(LinhaProducao linhaDeProducao) {
		mapaLinhaProducao.put(linhaDeProducao.getIdentificador(), linhaDeProducao);

	}
	
	public Collection<LinhaProducao> obterLista(){
		return mapaLinhaProducao.values();
	}
}
