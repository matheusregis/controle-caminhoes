package br.edu.ifcvideira.beans;

import java.security.Timestamp;

public class Motorista {
	private String nomeMotorista;
	private String telefone;
	private String cpf;
	private Timestamp horaChegada;
	private Timestamp horaDescarga;
	
	public Motorista() {
		
	}

	public String getNomeMotorista() {
		return nomeMotorista;
	}

	public void setNomeMotorista(String nomeMotorista) {
		this.nomeMotorista = nomeMotorista;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Timestamp getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(Timestamp horaChegada) {
		this.horaChegada = horaChegada;
	}

	public Timestamp getHoraDescarga() {
		return horaDescarga;
	}

	public void setHoraDescarga(Timestamp horaDescarga) {
		this.horaDescarga = horaDescarga;
	}
	

}
