package br.edu.infnet.RafaelLeiteFernandes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        
        FileReader file = new FileReader("files/producoesExtended.txt");
        BufferedReader leitura  = new BufferedReader(file);
        
        String linha = leitura.readLine();
        
        LinhaProducao linhaDeProducao = null;
        
        while(linha != null) {
            
            String[] campos = linha.split(";");
            
            switch (campos[0].toUpperCase()) {
            case "L":
                if (campos.length < 7) {
                    System.err.println("Linha inválida: " + linha);
                    break;
                }
                Supervisor supervisor = new Supervisor();
                supervisor.setNome(campos[2]);
                
                linhaDeProducao = new LinhaProducao();
                linhaDeProducao.setIdentificador(campos[1]);
                linhaDeProducao.setStatus(campos[3]);
                linhaDeProducao.setDataInicio(parseDate(campos[4]));
                linhaDeProducao.setDataFimPrevisto(parseDate(campos[5]));
                linhaDeProducao.setCustoOperacional(Double.parseDouble(campos[6]));
                linhaDeProducao.setSupervisor(supervisor);
                
                linhaDeProducao = linhaProducaoService.incluir(linhaDeProducao);
                System.out.println("LINHA ["+linhaDeProducao+"]");
                
                break;
            
            case "M":
                if (campos.length < 12) {
                    System.err.println("Linha inválida para componente mecânico: " + linha);
                    break;
                }
                ComponenteMecanico componenteMecanico = new ComponenteMecanico();
                componenteMecanico.setNome(campos[1]);
                componenteMecanico.setCodigo(campos[2]);
                componenteMecanico.setPreco(Double.parseDouble(campos[3]));
                componenteMecanico.setDataFabricacao(parseDate(campos[4]));
                componenteMecanico.setFornecedor(campos[5]);
                componenteMecanico.setEstoque(Integer.parseInt(campos[6]));
                componenteMecanico.setAtivo(Boolean.parseBoolean(campos[7]));
                componenteMecanico.setMaterial(campos[8]);
                componenteMecanico.setPeso(Double.parseDouble(campos[9]));
                componenteMecanico.setResistencia(Double.parseDouble(campos[10]));
                componenteMecanico.setProcessoFabricacao(campos[11]);
                componenteMecanico.setLinhaProducao(linhaDeProducao);
                
                componenteService.incluir(componenteMecanico);
                linhaDeProducao.getComponentes().add(componenteMecanico);

                break;
                
            case "E":
                if (campos.length < 12) {
                    System.err.println("Linha inválida para componente eletrônico: " + linha);
                    break;
                }
                ComponenteEletronico componenteEletronico = new ComponenteEletronico();
                componenteEletronico.setNome(campos[1]);
                componenteEletronico.setCodigo(campos[2]);
                componenteEletronico.setPreco(Double.parseDouble(campos[3]));
                componenteEletronico.setDataFabricacao(parseDate(campos[4]));
                componenteEletronico.setFornecedor(campos[5]);
                componenteEletronico.setEstoque(Integer.parseInt(campos[6]));
                componenteEletronico.setAtivo(Boolean.parseBoolean(campos[7]));
                componenteEletronico.setPotencia(Integer.parseInt(campos[8]));
                componenteEletronico.setTipoCircuito(campos[9]);
                componenteEletronico.setVoltagem(Integer.parseInt(campos[10]));
                componenteEletronico.setFrequencia(Integer.parseInt(campos[11]));
                componenteEletronico.setLinhaProducao(linhaDeProducao);
                
                componenteService.incluir(componenteEletronico);
                linhaDeProducao.getComponentes().add(componenteEletronico);

                break;

            default:
                System.err.println("Tipo de linha desconhecido: " + linha);
                break;
            }
            
            linha = leitura.readLine();
        }
        
        for(LinhaProducao l: linhaProducaoService.obterLista()) {
            System.out.println("Linha cadastrada com sucesso:" + l);
        }
        
        // CHAMADA DOS SERVICES
        System.out.println("###### linhaProducaoRespository ########" + linhaProducaoService.obterPorIdentificador("2"));
        
        leitura.close();
        
    }
    
    private Date parseDate(String dateStr) {
        try {
            return dateFormat.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}