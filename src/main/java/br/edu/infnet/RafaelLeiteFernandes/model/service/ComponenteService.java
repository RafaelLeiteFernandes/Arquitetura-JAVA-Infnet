package br.edu.infnet.RafaelLeiteFernandes.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.Componente;
import br.edu.infnet.RafaelLeiteFernandes.model.repository.ComponenteRepository;

@Service
public class ComponenteService {
		
	@Autowired
	private ComponenteRepository componenteRepository;
	
	public void incluir(Componente componente) {
		componenteRepository.save(componente);
	}
	
}