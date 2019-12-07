package br.edu.ifcvideira.beans;

public class Caminhao {
	private int codigo;
	private String placa;
	private int moduloCaminhao;
	private int tipoCaminhao;
	
	public Caminhao() {
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getModuloCaminhao() {
		return moduloCaminhao;
	}

	public void setModuloCaminhao(int moduloCaminhao) {
		this.moduloCaminhao = moduloCaminhao;
	}

	public int getTipoCaminhao() {
		return tipoCaminhao;
	}

	public void setTipoCaminhao(int tipoCaminhao) {
		this.tipoCaminhao = tipoCaminhao;
	}

	public Caminhao(int codigo, String placa, int tipoCaminhao, int moduloCaminhao) {
		this.codigo = codigo;
		this.placa = placa;
		this.tipoCaminhao = tipoCaminhao;
		this.moduloCaminhao = moduloCaminhao;
		
	}


	

}
