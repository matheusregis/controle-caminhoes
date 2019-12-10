package br.edu.ifcvideira.beans;

public class Produto {
	private String descricaoProduto;
	private float valorUnitario;
	private float quantidadeProduto;
	
	public Produto() {
		
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public float getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(float quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}


}
