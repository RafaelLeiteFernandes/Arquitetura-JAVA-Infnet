package br.edu.infnet.RafaelLeiteFernandes;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.RafaelLeiteFernandes.model.domain.Cliente;
import br.edu.infnet.RafaelLeiteFernandes.model.domain.Pedido;
import br.edu.infnet.RafaelLeiteFernandes.model.domain.Produto;
import br.edu.infnet.RafaelLeiteFernandes.model.domain.ProdutoAcabado;
import br.edu.infnet.RafaelLeiteFernandes.model.domain.SubProduto;

@Component
public class Loader implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/producoes.txt");
		BufferedReader leitura  = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		while(linha != null) {
			
			String[] campos = linha.split(";");
			
			switch (campos[0].toUpperCase()) {
			case "C":
				
				Cliente cliente = new Cliente();
				cliente.setNomeCliente(campos[1]);
				cliente.setEndereco(campos[2]);
				
				
				break;
				
			case "P":
				
				Produto produto = new Produto();
				produto.setCodigo(campos[1]);
				
				break;
			case "V":
				
				
				Pedido pedido = new Pedido();
				pedido.setStatus(campos[3]);
				
				break;
			case "A":
				
				ProdutoAcabado produtoAcabado = new ProdutoAcabado();
				produtoAcabado.setTipoEmbalagem(campos[6]);
				
				break;
			
			case "S":
				
				SubProduto subProduto = new SubProduto();
				subProduto.setDestino(campos[6]);
				
				break;

			default:;
				break;
			}
			
			System.out.println(linha);
			
			linha = leitura.readLine();
		}
		
		leitura.close();
	}

}
