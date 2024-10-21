package br.edu.infnet.RafaelLeiteFernandes.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.LinhaProducao;
import br.edu.infnet.RafaelLeiteFernandes.model.repository.LinhaProducaoRepository;

@Service
public class LinhaProducaoService {
	
	@Autowired
	private LinhaProducaoRepository linhaProducaoRepository;
	
	private  Map<String, LinhaProducao> mapaLinhaProducao = new HashMap<String, LinhaProducao>();
	
	public void incluir(LinhaProducao linhaDeProducao) {
		mapaLinhaProducao.put(linhaDeProducao.getIdentificador(), linhaDeProducao);
		
		linhaProducaoRepository.save(linhaDeProducao);

	}
	
	public Collection<LinhaProducao> obterLista(){
		return mapaLinhaProducao.values();
	}
}
