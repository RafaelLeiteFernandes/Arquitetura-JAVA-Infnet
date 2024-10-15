package br.edu.infnet.RafaelLeiteFernandes.model.domain;

public class ComponenteMecanico extends Componente {
	private String material;
    private double peso;
    private double resistencia;
    private String processoFabricacao;
    
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getResistencia() {
		return resistencia;
	}
	public void setResistencia(double resistencia) {
		this.resistencia = resistencia;
	}
	public String getProcessoFabricacao() {
		return processoFabricacao;
	}
	public void setProcessoFabricacao(String processoFabricacao) {
		this.processoFabricacao = processoFabricacao;
	}
}
