package br.edu.infnet.RafaelLeiteFernandes.model.domain;

public class ProdutoAcabado extends OrdemProducao {
	 private String tipoEmbalagem;
	 private String codigoDeBarras;
	 private boolean controleQualidade;
	 
	public String getTipoEmbalagem() {
		return tipoEmbalagem;
	}
	public void setTipoEmbalagem(String tipoEmbalagem) {
		this.tipoEmbalagem = tipoEmbalagem;
	}
	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}
	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}
	public boolean isControleQualidade() {
		return controleQualidade;
	}
	public void setControleQualidade(boolean controleQualidade) {
		this.controleQualidade = controleQualidade;
	}
}
