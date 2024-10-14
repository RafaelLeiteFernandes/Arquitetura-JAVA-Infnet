package br.edu.infnet.RafaelLeiteFernandes.model.domain;

public class SubProduto extends OrdemProducao{
	private String destino;
	private String lote;
    private boolean necessitaTratamento;
    
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public boolean isNecessitaTratamento() {
		return necessitaTratamento;
	}
	public void setNecessitaTratamento(boolean necessitaTratamento) {
		this.necessitaTratamento = necessitaTratamento;
	}
}
