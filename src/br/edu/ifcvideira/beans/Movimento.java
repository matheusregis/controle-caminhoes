package br.edu.ifcvideira.beans;

import java.security.Timestamp;

public class Movimento {
	private Timestamp dataChegada;
	private Timestamp dataDescarga;
	
	public Movimento() {
		
	}

	public Timestamp getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(Timestamp dataChegada) {
		this.dataChegada = dataChegada;
	}

	public Timestamp getDataDescarga() {
		return dataDescarga;
	}

	public void setDataDescarga(Timestamp dataDescarga) {
		this.dataDescarga = dataDescarga;
	}
}
