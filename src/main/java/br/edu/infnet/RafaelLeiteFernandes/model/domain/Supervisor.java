package br.edu.infnet.RafaelLeiteFernandes.model.domain;

public class Supervisor {
	private String nome;
    private int experiencia;
    private String certificacao;
    private int idade;
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	public String getCertificacao() {
		return certificacao;
	}
	public void setCertificacao(String certificacao) {
		this.certificacao = certificacao;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

}
