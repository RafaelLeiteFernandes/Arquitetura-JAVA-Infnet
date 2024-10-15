package br.edu.infnet.RafaelLeiteFernandes.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int numero;
	private float valorTotal;
	private String status;
	private Cliente cliente;
	private List<Produto> produtos;
	
	public Pedido() {
		produtos = new ArrayList<Produto>();
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
