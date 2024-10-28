package br.edu.infnet.RafaelLeiteFernandes;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.ComponenteEletronico;
import br.edu.infnet.RafaelLeiteFernandes.model.domain.ComponenteMecanico;
import br.edu.infnet.RafaelLeiteFernandes.model.domain.LinhaProducao;
import br.edu.infnet.RafaelLeiteFernandes.model.domain.Supervisor;
import br.edu.infnet.RafaelLeiteFernandes.model.service.ComponenteService;
import br.edu.infnet.RafaelLeiteFernandes.model.service.LinhaProducaoService;

@Component
public class Loader implements ApplicationRunner {
	
	@Autowired
	private LinhaProducaoService linhaProducaoService;
	@Autowired
	private ComponenteService componenteService;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/producoes.txt");
		BufferedReader leitura  = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		LinhaProducao linhaDeProducao = null;
		
		while(linha != null) {
			
			String[] campos = linha.split(";");
			
			switch (campos[0].toUpperCase()) {
			case "L":
				
				Supervisor supervisor = new Supervisor();
				supervisor.setNome(campos[2]);
				
				linhaDeProducao = new LinhaProducao();
				linhaDeProducao.setIdentificador(campos[1]);
				linhaDeProducao.setStatus(campos[3]);
				linhaDeProducao.setSupervisor(supervisor);
				
				
				linhaDeProducao = linhaProducaoService.incluir(linhaDeProducao);
				System.out.println("LINHA ["+linhaDeProducao+"]");
				
				
				linhaProducaoService.incluir(linhaDeProducao);
				
				break;
			
			case "M":
			        ComponenteMecanico componenteMecanico = new ComponenteMecanico();
			        componenteMecanico.setCodigo(campos[2]);
			        componenteMecanico.setLinhaProducao(linhaDeProducao);
			        componenteService.incluir(componenteMecanico);
			        
			        linhaDeProducao.getComponentes().add(componenteMecanico);

			    break;
			    
			    
			    case "E":
			        ComponenteEletronico componenteEletronico = new ComponenteEletronico();
			        componenteEletronico.setCodigo(campos[2]);
			        componenteEletronico.setLinhaProducao(linhaDeProducao);
			        
			        componenteService.incluir(componenteEletronico);
			        
			        linhaDeProducao.getComponentes().add(componenteEletronico);

			    break;

			default:
				break;
			}
			
			
			linha = leitura.readLine();
		}
		
		for(LinhaProducao l: linhaProducaoService.obterLista()) {
			System.out.println("Linha cadastrada com sucesso:" + l);

		}
		
		leitura.close();
		
	}

}
