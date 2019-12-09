package br.edu.ifcvideira.beans;

public class Fornecedor {
	private int idFornecedor;
	private String nomeFornecedor;
	private String cidade;
	private String estado;
	
	public Fornecedor() {
		
	}
	
	public int getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	
	public Fornecedor(int idFornecedor, String nomeFornecedor, String cidade, String estado) {
		this.idFornecedor = idFornecedor;
		this.nomeFornecedor = nomeFornecedor;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
