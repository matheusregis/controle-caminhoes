package br.edu.ifcvideira.beans;

import java.security.Timestamp;

public class NotaFiscal {
	private String numeroNotaFiscal;
	private Timestamp dataEmissaoNotaFiscal;
	
	public NotaFiscal() {
		
	}

	public String getNumeroNotaFiscal() {
		return numeroNotaFiscal;
	}

	public void setNumeroNotaFiscal(String numeroNotaFiscal) {
		this.numeroNotaFiscal = numeroNotaFiscal;
	}

	public Timestamp getDataEmissaoNotaFiscal() {
		return dataEmissaoNotaFiscal;
	}

	public void setDataEmissaoNotaFiscal(Timestamp dataEmissaoNotaFiscal) {
		this.dataEmissaoNotaFiscal = dataEmissaoNotaFiscal;
	}
	
	

}
