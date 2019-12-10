package br.edu.ifcvideira.beans;

import java.security.Timestamp;

public class NotaFiscal {
	private String numeroNotaFiscal;
	private String dataEmissaoNotaFiscal;
	private String produto;
	private int quantidade;
	private float valorUnitario;
	
	public NotaFiscal() {
		
	}

	public String getNumeroNotaFiscal() {
		return numeroNotaFiscal;
	}

	public void setNumeroNotaFiscal(String numeroNotaFiscal) {
		this.numeroNotaFiscal = numeroNotaFiscal;
	}

	public String getDataEmissaoNotaFiscal() {
		return dataEmissaoNotaFiscal;
	}

	public void setDataEmissaoNotaFiscal(String dataEmissaoNotaFiscal) {
		this.dataEmissaoNotaFiscal = dataEmissaoNotaFiscal;
	}
	
	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	

}
