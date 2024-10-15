package br.edu.infnet.RafaelLeiteFernandes.model.domain;

public class ComponenteEletronico extends Componente {
	  	private int potencia;
	    private String tipoCircuito;
	    private int voltagem;
	    private int frequencia;
	    
		public int getPotencia() {
			return potencia;
		}
		public void setPotencia(int potencia) {
			this.potencia = potencia;
		}
		public String getTipoCircuito() {
			return tipoCircuito;
		}
		public void setTipoCircuito(String tipoCircuito) {
			this.tipoCircuito = tipoCircuito;
		}
		public int getVoltagem() {
			return voltagem;
		}
		public void setVoltagem(int voltagem) {
			this.voltagem = voltagem;
		}
		public int getFrequencia() {
			return frequencia;
		}
		public void setFrequencia(int frequencia) {
			this.frequencia = frequencia;
		}
}
